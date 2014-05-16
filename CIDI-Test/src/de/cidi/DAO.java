package de.cidi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection con;
	private PreparedStatement pstlogin, psteintragen, pstwarteschlange, pstAnzUserVor, pstlogout, pst, pstgetsitzid;
	private ResultSet rst;
	private int idSitzung, idNutzer, IdaktSitz;
	
	public DAO() {
		verbindungAufbauen("jdbc:mysql://localhost:3306/cidi", "root", "mysql");
		this.idNutzer = -1;
		this.idSitzung = -1;
	}
	
	public void verbindungAufbauen(String url, String user, String pw){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				// error out
			}
			con = DriverManager.getConnection(url, user, pw);
			psteintragen = con.prepareStatement("");
			pstgetsitzid = con.prepareStatement("SELECT MAX(id_sitzung) FROM sitzung");
			pstlogout = con.prepareStatement("UPDATE sitzung SET endeSteuerung=NOW() WHERE id_sitzung=?");
			pstwarteschlange = con.prepareStatement("SELECT * FROM benutzer WHERE useFlag=true");
			pstAnzUserVor = con.prepareStatement("SELECT COUNT(id_sitzung) FROM sitzung WHERE endeSteuerung='0000-00-00 00:00:00' GROUP BY(endeSteuerung)");
			pstlogin = con.prepareStatement("SELECT id FROM benutzer WHERE nutzername=? AND passwort=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getIdSitzung() {
		return idSitzung;
	}

	public void setIdSitzung(int idSitzung) {
		this.idSitzung = idSitzung;
	}
	
	public void verbindungAbbauen() {
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		} else {
			System.out.println("Problem: verbindungAbbauen()");
		}
	}
	
	public Boolean anmelden(String benutzername, String pw) {
		try {
			pstlogin.setString(1, benutzername);
			pstlogin.setString(2, sha1(benutzername + pw));
			rst = pstlogin.executeQuery();
			if( rst.next() ){
				idNutzer = Integer.parseInt(rst.getString(1)); //geprüft passt
//				
				switch (warteschlange()) {
				case "leer":{
					psteintragen = con.prepareStatement("INSERT INTO sitzung (id_benutzer, login, beginnSteuerung) VALUES(" + this.idNutzer + ", NOW(), NOW())");
					psteintragen.executeUpdate();
					psteintragen = con.prepareStatement("UPDATE benutzer SET useFlag=true WHERE id=" + this.idNutzer);
					psteintragen.executeUpdate();
					setSitzID();
					rst.close();
					System.out.println("DAO leer -> anmelden()");
					return true;
					}
				case "anstellen":{
					System.out.println("in switch -> anstellen");
					psteintragen = con.prepareStatement("INSERT INTO sitzung (id_benutzer, login) VALUES(" + this.idNutzer + ", NOW())");
					psteintragen.executeUpdate();
					setSitzID();
					rst.close();
					return true;
					}

				default:{
					System.out.println("Problem: rückgabewert Warteschlange()!");
					rst.close();
					}
				}
			} else {
				System.out.println("Logindaten nicht gefunden! anmelden()");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rst != null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	private void setSitzID() throws SQLException {
		rst = pstgetsitzid.executeQuery();
		if( rst.next() ){
			this.idSitzung = rst.getInt(1);		//abspeichern sitzung in global Variablen
		}
	}

	private String warteschlange() throws SQLException {
		rst = pstwarteschlange.executeQuery();
		if( rst.next() ){
			rst.close();
			return "anstellen";
		} 
		rst.close();
		return "leer";
	}

	
	public boolean abmelden(){
		if(this.idSitzung != -1) {
			try {
				pst = con.prepareStatement("SELECT * FROM sitzung WHERE beginnSteuerung!='0000-00-00 00:00:00' AND endeSteuerung='0000-00-00 00:00:00' ");
				rst = pst.executeQuery();
				if(this.idSitzung == this.IdaktSitz && rst.next()){
					pstlogout.setInt(1, this.idSitzung);
					pstlogout.executeUpdate();
					
					pstlogout = con.prepareStatement("UPDATE benutzer SET useFlag=false WHERE id=" + this.idNutzer );
					pstlogout.executeUpdate();
		
					//	Sitzung wird frei... chekcen wer in Warteschlange als nächstes kommt und dann gleich buchen !!! -> Ab de lutzi!			
					bucheNaechsten();
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rst != null){
					try {
						rst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return false;
	}	
		
	private boolean bucheNaechsten() throws SQLException {
		int nextSitzID = getNextSitzungsID();
		pst = con.prepareStatement("SELECT id_benutzer FROM sitzung WHERE id_sitzung="+ nextSitzID);
		rst = pst.executeQuery();
		if (rst.next()){
			//System.out.println("Es steht jemand an, nächster wird eingebucht");
			pst = con.prepareStatement("UPDATE benutzer SET useFlag=true WHERE id=" + rst.getInt(1) );
			pst.executeUpdate();
			pst = con.prepareStatement("UPDATE sitzung SET beginnSteuerung=NOW() WHERE id_sitzung="+ nextSitzID);
			pst.executeUpdate();
			return true;
		}
		//System.out.println("Nichts neues wird gebucht da keine Ansteht");
		return false;
	}

	private int getNextSitzungsID() throws SQLException {
		pst = con.prepareStatement("SELECT id_sitzung FROM sitzung WHERE id_sitzung>"+ this.idSitzung +" LIMIT 1");
		rst = pst.executeQuery();
		if (rst.next()){
			return rst.getInt(1);
		}
			return -1;	//WEnn s kein nächsten gibt
	}

	public void wartenAbbrechen(){
		try {
			if( idSitzung != -1 ){
				pst = con.prepareStatement("DELETE FROM sitzung WHERE id_sitzung=" + this.idSitzung );
				pst.executeUpdate();
				idSitzung=-1;
				idNutzer=-1;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rst != null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getNutzername() {
		try {
			pst = con.prepareStatement("SELECT nutzername FROM benutzer WHERE id=" + idNutzer);
			rst = pst.executeQuery();
			if( rst.next() ){
				return rst.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rst != null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Fehler bei ziehen des Namens des Benutzers");
		return "möp";
	}
	
	public int getMaxWarteZeitsek() {
		int anzSchlange = -1, sek = -1;
		try {
				pstAnzUserVor = con.prepareStatement("SELECT TIMEDIFF(NOW(), beginnSteuerung), id_Sitzung FROM sitzung WHERE beginnSteuerung!='0000-00-00 00:00:00' AND endeSteuerung='0000-00-00 00:00:00'");
				rst = pstAnzUserVor.executeQuery();
				if( rst.next() ){  //Gibt es jemanden der Fährt Und wenn wie lange darf er noch fahren?
					String temp = rst.getString(1); //Zeit
					sek = Integer.parseInt(temp.substring(6, 8)) + (Integer.parseInt(temp.substring(3, 5)) * 60); //sekunden + (minuten * 60)
					//in var sek sind nun wartesekunden in int gespeichert
					IdaktSitz = rst.getInt(2); //Gibt id der Sitzung der fährt
					
					if(idSitzung != -1){ //Wenn ich bereits warte habe ich eine Sitzung ID -> (isSitzung != -1) 
						System.out.println("aktFahrer|eigneSitzID :"+ IdaktSitz +" | "+ this.idSitzung);
						if(IdaktSitz == this.idSitzung){
							return -1;
						}
						pstAnzUserVor = con.prepareStatement("SELECT COUNT(id_sitzung) FROM sitzung WHERE id_sitzung>" + IdaktSitz +" AND id_sitzung<"+ this.idSitzung);
						rst = pstAnzUserVor.executeQuery();
						if( rst.next() ){	 //Wie viele Leute müssen noch vor mir Warten -> faktor * 15
							anzSchlange = (rst.getInt(1));
						}else{
							return -1;
						}
						
					} else { //Nicht angemeldet maxwartezeit
						pstAnzUserVor = con.prepareStatement("SELECT COUNT(id_sitzung) FROM sitzung WHERE beginnSteuerung='0000-00-00 00:00:00' AND endeSteuerung='0000-00-00 00:00:00' GROUP BY(endeSteuerung)");
						rst = pstAnzUserVor.executeQuery();
						if(rst.next()){	//Gibt und wie viele sind noch in der Warteschlange
							anzSchlange = rst.getInt(1);
						} else {
							return 900-sek;
						}
					}
				} else {
					//Keiner vor ihm
					return -1;
				}
				return (( 900 - sek ) + (anzSchlange * 900));  // (900sek-ZeitbisJetztGefahren) + AnzWartendeUser * 60Sek * 15 min
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst!=null){
					rst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
    private String sha1(String input) {
        MessageDigest mDigest;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
	        byte[] result = mDigest.digest(input.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < result.length; i++) {
	            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println("hash konnte nicht gebildet werden");
		return "möp";
    }
}
