<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<link href="css/steuerung.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- Prüfung des Passworts und Benutzers -->
	<%
String name = request.getParameter("benutzername");
String password = request.getParameter("password");
//Benutzereingaben unbedingt filtern !!!
if(name != null && name.length() > 0 && name.matches("[A-Za-z ]*")) {
out.println("Name ist " + name +" Password ist "+ password);

} else {
out.println("Eingabe ist Falsch");	
}	
%>
	<div align="center">
		<div id="steuerung-box">
			<table>
				<tr>
					<td><div id="steuerung-livetext">Live-view</div></td>
					<td><div id="steuerung-Ueber">Connect it, Drive it</div></td>
				<tr>
				<tr>
					<td><a href="#"><img src="images/screen.jpg" width="300"
							height="120" /></a></td>
					<td><table id="steuerung-timerbox">
							<tr>
								<td><div class="steuerung-timertext">Verbleibene Zeit</div></td>
							</tr>
							<tr>

								<td><div id="steuerung-timer">
										<input type="submit" value="TIMER" />
									</div></td>
							</tr>
							<tr>
								<td><div class="steuerung-timertext">Benutzername</div></td>
							</tr>
						</table></td>
				</tr>
			</table>

			<!-- Lampen buttons -->
			<table id="buttontable-lichter">
				<tr>
					<td>

						<div>
							<button name="Hupe" type="button" value="hupebutton"
								id="buttonHupe">
								<p>
									<img src="images/hupe_inaktiv.png" width="50" height="50"
										alt="Hupe" id="imgHupe"><br>
								</p>
							</button>
						</div>

					</td>
					<td>

						<div>
							<button name="Fernlicht" type="button" value="fernlichtbutton"
								id="buttonFernlicht">
								<p>
									<img src="images/fernlicht_inaktiv.png" width="50" height="50"
										alt="Fernlicht" id="imgFernlicht"><br>
								</p>
							</button>
						</div>

					</td>
					<td>

						<div>
							<button name="Abblendlicht" type="button"
								value="abblendlichtbutton" id="buttonAbblendlicht">
								<p>
									<img src="images/abblendlicht_inaktiv.png" width="50"
										height="50" alt="Abblendlicht" id="imgAbblendlicht"><br>
								</p>
							</button>
						</div>

					</td>
					<td>
						<div id="button-verbindungabbrechen">
							<FORM action="webshop.jsp">
								<INPUT type="submit" value="Verbindung abbrechen" />
							</FORM>
						</div>
					</td>
			</table>
			<!-- Steurungsbutton -->
			<table id="steuerung-button">
				<tr>
					<td></td>
					<td>

						<div>
							<button name="Pfeiloben" type="button" value="pfeilobenbutton"
								id="buttonPfeiloben">
								<p>
									<img src="images/oben_inaktiv.png" width="50" height="50"
										alt="Pfeiloben" id="imgPfeiloben"><br>
								</p>
							</button>
						</div>

					</td>
					<td></td>
				</tr>
				<tr>
					<td>

						<div>
							<button name="Pfeillinks" type="button" value="pfeillinksbutton"
								id="buttonPfeillinks">
								<p>
									<img src="images/links_inaktiv.png" width="50" height="50"
										alt="Pfeillinks" id="imgPfeillinks"><br>
								</p>
							</button>
						</div>

					</td>
					<td>

						<div>
							<button name="Pfeilunten" type="button" value="pfeiluntenbutton"
								id="buttonPfeilunten">
								<p>
									<img src="images/unten_inaktiv.png" width="50" height="50"
										alt="Pfeilunten" id="imgPfeilunten"><br>
								</p>
							</button>
						</div>

					</td>
					<td>

						<div>
							<button name="Pfeilrechts" type="button"
								value="pfeilrechtsbutton" id="buttonPfeilrechts">
								<p>
									<img src="images/rechts_inaktiv.png" width="50" height="50"
										alt="Pfeilrechts" id="imgPfeilrechts"><br>
								</p>
							</button>
						</div>

					</td>
				</tr>
			</table>






			<footer id="steuerung-footer">
				<div id="steuerung-webshop">
					<table>
						<tr>
							<td><a href="AGB.jsp">AGB</a></td>
							<td><a href="Impressum.jsp">Impressum</a></td>
							<td><FORM action="webshop.jsp">
									<INPUT type="submit" value="Zum Webshop" />
								</FORM></td>
						</tr>
					</table>
				</div>
			</footer>
		</div>


	</div>





	<SCRIPT type="text/javascript" src="js/steuerung.js"></SCRIPT>
</body>

</html>