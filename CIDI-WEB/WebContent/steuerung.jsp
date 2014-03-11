<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<link href="bedienung.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div style="padding: 0 0 0 300px;">
<div id="steuerung-box">
<table>
<tr><td>Live-view</td><td>"Connect it, Drive it"</td><tr>
<tr><td><a href="#"><img src="images/screen.jpg" width="300" height="120"/></a></td>
<td><table id="test"> 
		<tr><td>Verbleibene Zeit</td></tr>
		<tr><td><input type="submit" value="TIMER"/></td></tr>
		<tr><td>Benutzername</td></tr>
		</table>
</td></tr>
</table>
<!-- Lampen buttons -->
<table>
<tr><td>
<form action="button.htm">
  <div>
    <button name="Hupe" type="button"
      value="hupebutton" onclick="alert('Hupe!');">
      <p>
        <img src="images/hupe.png" width="50" height="50" alt="Hupe"><br>
      </p>
    </button>
  </div>
</form>

</td>
<td>
<form action="button.htm">
  <div>
    <button name="Fernlicht" type="button"
      value="fernlichtbutton" onclick="alert('Fernlicht!');">
      <p>
        <img src="images/fernlicht.png" width="50" height="50" alt="Fernlicht"><br>
      </p>
    </button>
  </div>
</form>
</td>
<td>
<form action="button.htm">
  <div>
    <button name="Abblendlicht" type="button"
      value="abblendlichtbutton" onclick="alert('Abblendlicht!');">
      <p>
        <img src="images/abblendlicht.png" width="50" height="50" alt="Abblendlicht"><br>
      </p>
    </button>
  </div>
</form>
</td>
<td>
<p>Verbindung beenden</p>
</td>
</table>
<!-- Steurunsbutton -->
<table>
<tr><td></td><td>
<form action="button.htm">
  <div>
    <button name="Pfeiloben" type="button"
      value="pfeilobenbutton" onclick="alert('Pfeiloben!');">
      <p>
        <img src="images/pfeiloben.png" width="50" height="50" alt="Pfeiloben"><br>
      </p>
    </button>
  </div>
</form>
</td>
<td></td></tr>
<tr><td>
<form action="button.htm">
  <div>
    <button name="Pfeillinks" type="button"
      value="pfeillinksbutton" onclick="alert('Abblendlicht!');">
      <p>
        <img src="images/pfeillinks.png" width="50" height="50" alt="Pfeillinks"><br>
      </p>
    </button>
  </div>
</form>
</td>
<td>
<form action="button.htm">
  <div>
    <button name="Pfeilrechts" type="button"
      value="pfeilrechtsbutton" onclick="alert('Pfeilrechts!');">
      <p>
        <img src="images/pfeilrechts.png" width="50" height="50" alt="Pfeilrechts"><br>
      </p>
    </button>
  </div>
</form>
</td>
<td>
<form action="button.htm">
  <div>
    <button name="Pfeilunten" type="button"
      value="pfeiluntenbutton" onclick="alert('Pfeilunten!');">
      <p>
        <img src="images/pfeilunten.png" width="50" height="50" alt="Pfeilunten"><br>
      </p>
    </button>
  </div>
</form>
</td></tr>
</table>




</div>
</div>




<footer id="steuerung-footer">
	<div id="steuerung-webshop">
		<table>
			<tr><td>AGB</td><td>Impressum</td><td><input type="submit" value="Zum Webshop"/></td></tr>
		</table>
	</div>
</footer>
</body>
</html>