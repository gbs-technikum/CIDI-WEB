<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="js/countdown.js"></script>
</head>
<body>
	<!-- Prüfung des Passworts und Benutzers -->
	<div align="center">
		<div id="login-box">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<h1>Connect it, Drive it</h1>
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
										<form action="Test" method="post">

											<tr>
												<th>Benutzername</th>
												<td><input type="text" value="Max" name="benutzername" />
												</td>
											</tr>
											<tr>
												<th>Password
												<td><input type="password" value="Mustermann"
													name="password" /></td>
											</tr>
											<tr>
												<th><input type="reset" value="Abbrechen" /></th>
												<td><input type="submit" value="Anmelden" /></td>
											</tr>

										</table>
									</form>
								</td>
								<td><a href="#"><img src="images/screen.jpg"
										width="300" height="120"></a></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<table id="timerbox">
										<tr>
											<td>Verbleibene Wartezeit: <a id="countdown-timer"></a></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
			</table>

			<footer id="login-footer">
				<div id="login-webshop">
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
	<SCRIPT type="text/javascript" src="js/countdown.js"></SCRIPT>
</body>

</html>

