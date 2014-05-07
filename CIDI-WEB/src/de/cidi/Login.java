package de.cidi;

import java.io.PrintWriter;

public class Login {
	private SQL mysql;
	private String pruefung;
	private String user ="huber";
	private String passwd ="huber";
	

	public Login(String user, String passwd, PrintWriter pw) {
		this.user = user; 
		this.passwd = passwd;
		String html;
		if(pruefung == "Logindaten korrekt | Sitzung belegt"){

			html = "<html><head><body>" + "<meta http-equiv='refresh'"
					+ "content='0; url=steuerung.jsp'>"
					+ "</head><body>richtig</body></html>";

		} else {
			html = "<html><head><body>" + "<meta http-equiv='refresh'"
					+ "content='0; url=index.jsp'>"
					+ "</head><body>falsch</body></html>";

		}
		pw.print(html);
	}
	
	public  void main(String[] args) {
		SQL mysql = new SQL();
		pruefung = mysql.pruefeLogin(user, passwd);
		
		System.out.println(pruefung);
	}

}
