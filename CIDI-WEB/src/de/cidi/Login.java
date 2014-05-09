package de.cidi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CIDI
 */
// @WebServlet("CIDI")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAO mysql;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		mysql = new DAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String user = request.getParameter("benutzername");
		String passwd = request.getParameter("password");
		boolean pruefung = false;
		String html;
		String wartezeit;
		int zeit = mysql.getMaxWarteZeitsek();
		wartezeit = mysql.wartenschlange()
		System.out.println("Die Zeit  " + zeit);
		if (zeit == -1) {
			pruefung = mysql.anmelden(user, passwd);
			if (pruefung == true) {
				html = "<html><head><body>" + "<meta http-equiv='refresh'"
						+ "content='0; url=steuerung.jsp'>"
						+ "</head><body></body></html>";
			} else {

				html = "<html><head><body>" + "<meta http-equiv='refresh'"
						+ "content='0; url=login.jsp'>"
						+ "</head><body></body></html>";
			}
		} else {
		
				html = "<html><head><body>" + "<meta http-equiv='refresh'"
						+ "content='0; url=login.jsp'>"
						+ "</head><body></body></html>";
			
		}

		pw.print(html);

	}

	public static DAO getMysql() {
		return mysql;
	}

}