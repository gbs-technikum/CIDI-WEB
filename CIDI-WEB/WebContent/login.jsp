<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Connect it, Drive it</title>
<style>
#login-box {
	width:600px;
	height: 300px;
	color: black;
	font: 12px Arial, Helvetica, sans-serif;
	border-style: solid;
	border-color:black;
	border-width:2px;
}

#login-box img {
	border:none;
}
#login-eingabebox{
	border-style: solid;
	border-color:black;
	border-width:2px;
}

#test{
border-style: solid;
	border-color:black;
	border-width:2px;
}
#login-textbox {
	background-color:#b7b7b7;
	border-style: solid;
	border-color:black;
	border-width:2px;
}

#login-livetext {
	background-color:#b7b7b7;
	border-style: solid;
	border-color:black;
	border-width:2px;
	margin-left: 100px;
	font: bold 20px "Calibri", Arial;
}

#login-anmelde{
	margin-top: 10px;
	padding: 10px 10px 10px 10px;
	background-color:#d9d9d9;
	border-style: solid;
	border-color:black;
	border-width:2px;
	

}
#login-box h1{
	width: 265px;
	border-style: solid;
	border-color:black;
	border-width:2px;
	padding:0;
	margin:0;
	font: bold 30px "Calibri", Arial;
	text-align: center 
}
#login-webshop{
	padding: 0 0 0 350px;
	width: 103px; 
	height: 42px; 
}

#login-footer{
	margin-left:20px;
	padding: 10px 0 0 0;
	width: 38em;
	height: 50px;
}
#timerbox{
margin-left:110px;
}
.form-login  {
	width: 205px;
	padding: 10px 4px 6px 3px;
	border: 1px solid #0d2c52;
	background-color:#1e4f8a;
	font-size: 16px;
	color: #ebebeb;
}


.login-box-options  {
	clear:both;
	padding-left:87px;
	font-size: 11px;
}

.login-box-options a {
	color: #ebebeb;
	font-size: 11px;
}

</style>

</head>
<body>
<div style="padding: 0 0 0 300px;">
<div id="login-box">
<table>
<tr><td>
<table>  
	<tr><td>
		<h1>"Connect it, Drive it"</h1>
	</td><td>
		<div id="login-livetext">Live-View</div>
	</td></tr>
</table>

<table>
<tr><td>
	<table id="login-anmelde">
		<tr><th><div id="login-textbox">Benutzername</div></th><td><div id="login-eingabebox"><input type="text" value="Max" name ="benutzername"/></div></td></tr>
		<tr><th><div id="login-textbox">Password</div><td><div id="login-eingabebox"><input type="text" value="Mustermann" name ="password"/></div></td></tr>
		<tr><th><input type="submit" value="Abbrechen" /></th>
		<td><input type="submit" value="Anmelden"/></td></tr>
	</table>
</td><td>
			<a href="#"><img src="images/screen.jpg" width="300" height="120"/></a>
</td></tr>
<tr><td></td><td>
		<table id="timerbox">
			<tr><td>Verbleibene Wartezeit<td><td><input type="submit" value="TIMER"/>
			</td></tr>
		</table>
		</td></tr>
</table>
</div>



<footer id="login-footer">
	<div id="login-webshop">
		<table>
			<tr><td>AGB</td><td>Impressum</td><td><input type="submit" value="Zum Webshop"/></td></tr>
		</table>
	</div>
</footer>
</body>
</html>