package de.cidi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CIDI
 */
public class GETDATA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAO mysql;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GETDATA() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		mysql = Login.getMysql();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init();
		PrintWriter pw = response.getWriter();
		pw.print(mysql.getMaxWarteZeitsek());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		init();
		Login.getSession(request);
		PrintWriter pw = response.getWriter();
		System.out.println(mysql.getMaxWarteZeitsek());
		pw.print(mysql.getMaxWarteZeitsek());
		
	}
}