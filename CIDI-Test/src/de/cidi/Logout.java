package de.cidi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet{
	private DAO db;
	private static final long serialVersionUID = 1L;
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		db = Login.getMysql();
	}

	public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		db.abmelden();								//SQL User abmelden
	
		response.sendRedirect( "login.jsp" );		//weiterleitung an Login
	}

}