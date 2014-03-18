<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="padding: 0 0 0 300px;">
		<div id="login-box">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<h1>"Connect it, Drive it"</h1>
								</td>
								<td>
									<div id="login-livetext">Live-View</div>
								</td>
							</tr>
						</table>

						<table>
							<tr>
								<td>
									<table id="login-anmelde">
										<tr>
											<th><div id="login-textbox">Benutzername</div></th>
											<td><div id="login-eingabebox">
													<input type="text" value="Max" name="benutzername" />
												</div></td>
										</tr>
										<tr>
											<th><div id="login-textbox">Password</div>
											<td><div id="login-eingabebox">
													<input type="text" value="Mustermann" name="password" />
												</div></td>
										</tr>
										<tr>
											<th><input type="submit" value="Abbrechen" /></th>
											<td><input type="submit" value="Anmelden" /></td>
										</tr>
									</table>
								</td>
								<td><a href="#"><img src="images/screen.jpg"
										width="300" height="120"></a></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<table id="timerbox">
										<tr>
											<td><a>Verbleibene Wartezeit: </a> <a id="countdown-timer"></a></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						</div> <footer id="login-footer">
							<div id="login-webshop">
								<table>
									<tr>
										<td>AGB</td>
										<td>Impressum</td>
										<td><FORM action="webshop.jsp">
												<INPUT type="submit" value="Zum Webshop" />
											</FORM></td>
									</tr>
								</table>
							</div>
						</footer> <SCRIPT type="text/javascript" src="js/countdown.js"></SCRIPT>
</body>
</html>