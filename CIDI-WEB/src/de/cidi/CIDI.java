package de.cidi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CIDI
 */
//@WebServlet("CIDI")
public class CIDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SQL mysql;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CIDI() {
        super();
        mysql = new SQL();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String user = request.getParameter("benutzername");
		String passwd =  request.getParameter("password");
		String html;
		String mysqluseer = mysql.getUser();		//root
		String mysqlpasswd = mysql.getPasswort();	//mysql
		
		
		if(user.equals(mysqluseer) && passwd.equals(mysqlpasswd)) {
			
			html = "<html><head><body>"
					+ "<meta http-equiv='refresh'"
					+ "content='0; url=steuerung.jsp'>"
					+ "</head><body><h1>richtig</h1></body></html>";
			

		} else {
			html = "<html><head><body>"
					+ "<meta http-equiv='refresh'"
					+ "content='0; url=index.jsp'>"
					+ "</head><body><h1>falsch</h1></body></html>";
		
			
		}	
			pw.print(html);
		}

}
