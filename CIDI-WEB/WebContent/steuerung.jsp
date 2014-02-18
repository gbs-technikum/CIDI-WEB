<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<style>
#steuerung-box {
	width:600px;
	height: 500px;
	color: black;
	font: 12px Arial, Helvetica, sans-serif;
	border-style: solid;
	border-color:black;
	border-width:2px;
}

#steuerung-box img {
	border:none;
}
#steuerung-eingabebox{
	border-style: solid;
	border-color:black;
	border-width:2px;
}

#test{
border-style: solid;
	border-color:black;
	border-width:2px;
}
#steuerung-textbox {
	background-color:#b7b7b7;
	border-style: solid;
	border-color:black;
	border-width:2px;
}

#steuerung-livetext {
	background-color:#b7b7b7;
	border-style: solid;
	border-color:black;
	border-width:2px;
	margin-left: 100px;
	font: bold 20px "Calibri", Arial;
}

#steuerung-anmelde{
	margin-top: 10px;
	padding: 10px 10px 10px 10px;
	background-color:#d9d9d9;
	border-style: solid;
	border-color:black;
	border-width:2px;
	

}
#steuerung-box h1{
	width: 265px;
	border-style: solid;
	border-color:black;
	border-width:2px;
	padding:0;
	margin:0;
	font: bold 30px "Calibri", Arial;
	text-align: center 
}
#steuerung-webshop{
	padding: 0 0 0 350px;
	width: 103px; 
	height: 42px; 
}

#steuerung-footer{
	margin-left:20px;
	padding: 10px 0 0 0;
	width: 38em;
	height: 50px;
}
#timerbox{
margin-left:110px;
}
.form-steuerung  {
	width: 205px;
	padding: 10px 4px 6px 3px;
	border: 1px solid #0d2c52;
	background-color:#1e4f8a;
	font-size: 16px;
	color: #ebebeb;
}


.steuerung-box-options  {
	clear:both;
	padding-left:87px;
	font-size: 11px;
}

.steuerung-box-options a {
	color: #ebebeb;
	font-size: 11px;
}
</style>
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