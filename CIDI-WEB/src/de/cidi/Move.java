package de.cidi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Move extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
    public Move() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String left = request.getParameter("left");
		String right = request.getParameter("right");
		String up = request.getParameter("up");
		String down = request.getParameter("down");
		
		String html = "<html><body><h1>left: "+left+" right: "+right+" up: "+up+" down: "+down+"</h1></body></html>";
		pw.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	
}
