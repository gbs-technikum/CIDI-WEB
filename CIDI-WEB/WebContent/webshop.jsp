<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<link href="css/webshop.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
		<div id="webshop-box">
			<h1>"Connect it, Drive it" Webshop</h1>
			<table>
				<tr>
					<td id="webshop-boxlinks">
						<nav>
							<ul>
								<li><a href="./AGB.jsp">AGB</a></li>
								<li><a href="./impressum.jsp">Impressum</a></li>
							</ul>
						</nav>
					</td>
					<td>
						<form action="warenkorb.jsp" method="post">
							<table id="webshop-boxrechts">
								<tr>
									<td id="webshop-boxrechtstext">Connect it, Drive it</td>
									<td><input type="text" size="20" maxlength="20"
										name="Menge" value="1" /> <input type="submit"
										value="in den Warenkorb" /></td>
								</tr>
							</table>
						</form>
						<table>
							<tr>
								<th><p>Preis</p></th>
								<td><p>XX Euro</p></td>
							</tr>
							<tr>
								<td id="webshop-beschreibungbild"><img
									src="images/screen.jpg" width="100" height="100" /></td>
								<td id="webshop-beschreibungtext">
									<p>Ein handelsübliches, ferngesteuertes Auto mit Webcamera.
									
								</td>
							</tr>
						</table>
			</table>
		</div>
	</div>
</body>
</html>