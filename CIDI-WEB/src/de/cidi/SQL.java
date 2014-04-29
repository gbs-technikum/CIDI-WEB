package de.cidi;



import java.sql.*;

public class SQL {

	public String getSqlBefehl() {
		return sqlBefehl;
	}

	public void setSqlBefehl(String sqlBefehl) {
		this.sqlBefehl = sqlBefehl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	PreparedStatement pst = null;
	ResultSet rst = null;
	Connection connection = null;
	String sqlBefehl = "";
	String datenbankpfad, user, passwort;
	
	
	public SQL() {
		datenbankpfad = "jdbc:mysql://localhost:3306/cidi" ;
		user = "root" ;
		passwort = "mysql" ;
		
		verbindung();
	}

	private void verbindung() {
		//Verbindung DB cidi
		try {
			connection = DriverManager.getConnection(datenbankpfad, user, passwort);
			System.out.println("-> Verbindung hergestellt!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("-> Zonk keine Verbindung DB");
		}
	}
	
	public String pruefeLogin(String nutzerName, String pw){
		try {
			//Abfrage
			pst =  connection.prepareStatement("SELECT id FROM Benutzer WHERE nutzername=? AND passwort=?");
			pst.setString(1,nutzerName);
			pst.setString(2, pw);
			rst = pst.executeQuery();
			
			if(rst.next()){
				System.out.println("Benutzer in Datenbank vorhanden/korrekt!");
				String NutzerID = rst.getString(1);  //zwischenspeichern der ID des Nutzers der fährt  ->bessere Lesbarkeit
				
				//Prüfen ob irgendwo ein true gesetzt ist
				pst = connection.prepareStatement("SELECT * FROM benutzer WHERE useFlag=true");
				rst = pst.executeQuery();

				if(!(rst.next())){	//Abfrage ob restTemp ein Element beinhaltet
				//useFlag frei ... daher in SQL-Benutzer dieses setzen 
					sqlBefehl = "UPDATE benutzer SET useFlag=true WHERE id=" + NutzerID;
					pst.executeUpdate(sqlBefehl);  //Abfrage absetzen
				//Eintrag in SQL-Sitzugn 
					sqlBefehl = "INSERT into Sitzung (id_benutzer, beginnSitzung) VALUES ("+ NutzerID +", NOW())";
					pst = connection.prepareStatement(sqlBefehl);
					pst.executeUpdate(sqlBefehl);  //Abfrage absetzen

					return "Logindaten korrekt | Sitzung wird belegt";
				} else { //useFlag besetzt/true
					return "Logindaten korrekt | Sitzung belegt";
				}
			} else {
				System.out.println("->Nutzername oder Passwort falsch, bitte nochmal versuchen!");
				return "Logindaten falsch";
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
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "zonk -> Kein Benutzerzeug gefunden";
	}

	public void logout(){ //ausstempln wird gesetzt und useFlag wieder auf false
		try {
			this.verbindung(); //Verbing erneut aufbauen, da sie beim eintrag geschlossen worden ist
			//Prüfen ob irgendwo ein true gesetzt ist
			pst = connection.prepareStatement("SELECT * FROM benutzer WHERE useFlag=true");
			rst = pst.executeQuery();
			if( rst.next() ){	//Abfrage ob rst bei Tabelle Bnutzer ein TRUE beinhaltet
					//useFlag freigeben ... auf false setzen 
					sqlBefehl = "UPDATE benutzer SET useFlag=false WHERE id=" + rst.getString(1);
					pst.executeUpdate(sqlBefehl);  //Abfrage absetzen
					
					//Eintrag in SQL-Sitzugn bzw. ausgangsstempel 
					sqlBefehl = "UPDATE Sitzung SET endeSitzung=NOW() ORDER BY beginnSitzung DESC LIMIT 1";
//					UPDATE status_log SET zeit=now() ORDER BY zeit DESC LIMIT 1;
					pst = connection.prepareStatement(sqlBefehl);
					pst.executeUpdate(sqlBefehl);  //Abfrage absetzen
					
			} else { //useFlag besetzt/true
				System.out.println("-> Zonk .. niemand ist angemeldet (SQL-logout-Methode)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	

	
//	public static void main(String[] args) {
//		SQL s = new SQL();
//		System.out.println(s.pruefeLogin("becker", "becker"));
//		
//		s.logout();
//	}
}




