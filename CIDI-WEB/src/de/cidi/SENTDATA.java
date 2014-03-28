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
		c = Controller.getInstance();
	}

	public SENTDATA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int left	=	Integer.parseInt(request.getParameter("left"));
		int right 	=	Integer.parseInt(request.getParameter("right"));
		int up 		= 	Integer.parseInt(request.getParameter("up"));
		int down 	= 	Integer.parseInt(request.getParameter("down"));
		int flicht 	= 	Integer.parseInt(request.getParameter("flicht"));
		int alicht 	= 	Integer.parseInt(request.getParameter("alicht"));
		int hupe 	= 	Integer.parseInt(request.getParameter("hupe"));
		c.foo();
		System.out.println("left: "+left+" right: "+right+" up: "+up+" down: "+down+" flicht: "+flicht+" alicht: "+alicht+" hupe: "+hupe);
	}

}
