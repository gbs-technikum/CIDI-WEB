package de.cidi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CLOSE extends HttpServlet{

	private Controller c;
	private DAO db;
	private static final long serialVersionUID = 1L;
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//c = Controller.getInstance();
		db = Login.getMysql();
	}

	public CLOSE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//c.close();									//Verbindung trennen
		db.abmelden();								//SQL User abmelden
	
		response.sendRedirect( "login.jsp" );		//weiterleitung an Login
	}

}
