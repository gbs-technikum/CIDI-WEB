package de.cidi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Servlet implementation class CIDI
 */
// @WebServlet("CIDI")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DAO mysql;
	private static boolean pruefung = false;
	private int wartezeitMin;
	private int wartezeitSek;
	private String html;
	private PrintWriter pw;
	private HttpServletResponse response;

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
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		pw = response.getWriter();
		
		html=""+pruefung;
		pw.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response1) throws ServletException, IOException {
		this.response=response1;
		pw = response.getWriter();
		String user = request.getParameter("benutzername");
		String passwd = request.getParameter("password");
		int zeit;
		pruefung = mysql.anmelden(user, passwd);
		if (pruefung == true) {
			setSession(request);
			zeit = mysql.getMaxWarteZeitsek();
			if (zeit == -1) {
				response.sendRedirect("steuerung.jsp");
			} else {
				html = "<!DOCTYPE html><html xmlns='http://www.w3.org/1999/xhtml'><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' /><title>Connect it, Drive it</title><link href='css/login.css' rel='stylesheet' type='text/css' /><script src='http://jwpsrv.com/library/z5V7TllCEeOs8iIACqoGtw.js'></script><script src='js/countdown.js'></script><script src='Login'></script></head><body><div align='center'><div id='login-box'><table><tr><td><table><tr><td><h1>Connect it, Drive it</h1></td><td><div id='login-livetext'>Live-View</div></td></tr></table><table><tr><td><table id='login-anmelde'><form name='loginform' action='Login' method='post'><tr><th>Benutzername</th><td><input type='text'"
						+ "value='"
						+ user
						+ "'"
						+ "name='benutzername' disabled='disabled'/></td></tr><tr><th>Password<td><input type='password' value='Mustermann' name='password'  disabled='disabled'/></td></tr><tr><th><input id='reset' name='reset_button' type='reset' value='Abbrechen' /></th><td><input id='submit' name='submit_button' type='submit' value='Anmelden'  disabled='disabled'/></td></tr></form></table></td><td><embed type='application/x-vlc-plugin' pluginspage='http://www.videolan.org' version='VideoLAN.VLCPlugin.2'  width='350' controls='false' height='240' id='vlc' loop='yes' autoplay='yes' target='rtsp://192.168.15.85:8554/'></embed></td></tr><tr><td></td><td><table id='timerbox'><tr><td>Verbleibene Wartezeit: <a id='countdown-timer'></a></td></tr></table></td></tr></table></table><footer id='login-footer'><div id='login-webshop'><table><tr><td><a href='AGB.jsp'>AGB</a></td><td><a href='Impressum.jsp'>Impressum</a></td><td><FORM action='webshop.jsp'><INPUT type='submit' value='Zum Webshop' /></FORM></td></tr></table></div></footer></div></div><SCRIPT type='text/javascript' src='js/countdownwart.js'></SCRIPT></body></html>";
				//CountDown();
				
				
				pw.print(html);

			}

		} else {
			response.sendRedirect("login.jsp");
		}

	}


    public void CountDown() {
    	getTimesql();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	System.out.println("Timer A in actionperformer: "+ wartezeitMin + " " + wartezeitSek);
				if (wartezeitMin == 0 && wartezeitSek == 0|| wartezeitMin == -666) {
					System.out.println("los");
					try {
						response.sendRedirect("steuerung.jsp");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("bla");
					}
				}
				wartezeitSek--;
				if (wartezeitSek < 0) {
					wartezeitSek = 59;
					wartezeitMin--;
				}

				if (wartezeitSek % 10 == 0) { // Pr�ft alle 10 sekunden ob sich die WarteZeit ver�ndert hat
					getTimesql();
				}
            }
        };
        timer.schedule(task, 0, 1000);
    }


	private void getTimesql() {
		int i = mysql.getMaxWarteZeitsek();
		// System.out.println("getTimesql() wert von DAO" + i);
		if (i != -1) {
			this.wartezeitSek = i % 60;
			this.wartezeitMin = i / 60;
		} else {
			this.wartezeitMin = -666;
		}
	}
	

	public static DAO getMysql() {
		return mysql;
	}

	public static boolean getLogin() {
		return pruefung;
	}
	public void setSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("sessionID", "" + mysql.getIdSitzung());
	}
	
	public static void getSession(HttpServletRequest request){
		int id=-1;
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionID")!=null){
			id=Integer.parseInt((String)session.getAttribute("sessionID"));
			mysql.setIdSitzung(id);
		}
			System.out.println("id: " + id+" s: "+session.getAttribute("sessionID"));
	}
}