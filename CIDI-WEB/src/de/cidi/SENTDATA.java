package de.cidi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SENTDATA extends HttpServlet{

	private Controller c;
	private static final long serialVersionUID = 1L;
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		c = Controller.getInstance();				//Controller Instance holen
	}

	public SENTDATA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get werte abrufen
		
		boolean left	=	Boolean.parseBoolean(request.getParameter("left"));
		boolean right 	=	Boolean.parseBoolean(request.getParameter("right"));
		boolean up 		= 	Boolean.parseBoolean(request.getParameter("up"));
		boolean down 	= 	Boolean.parseBoolean(request.getParameter("down"));
		boolean flicht 	= 	Boolean.parseBoolean(request.getParameter("flicht"));
		boolean alicht 	= 	Boolean.parseBoolean(request.getParameter("alicht"));
		
		c.drive(left,right,up,down,flicht,alicht);				//Werte an Controller übergeben
	}

}