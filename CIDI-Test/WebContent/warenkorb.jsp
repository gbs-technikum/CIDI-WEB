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
	<div align="center">
		<!-- Prüfung des Passworts und Benutzers -->
		<%
			String menge = request.getParameter("Menge");
			int intZahl;
			int preis = 20;
			int erg;
			//Benutzereingaben unbedingt filtern !!!
			if (menge != null && menge.length() > 0 && menge.matches("[0-9 ]*")) {
				intZahl = Integer.parseInt(menge);
				erg = intZahl * preis;
				out.println("Die Menge ist " + intZahl + " und es kostet  "
						+ erg + " Euro");

			} else {
				out.println("Eingabe ist Falsch");
			}
		%>

	</div>
</body>
</html>