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
	width:333px;
	height: 352px;
	padding: 58px 76px 0 76px;
	color: black;
	font: 12px Arial, Helvetica, sans-serif;
	background: url(images/background.jpg) no-repeat left top;
}

#index-box img {
	border:none;
}

#login-button{
	padding: 280px 76px 40px 40px;
	width: 103px; 
	height: 42px; 
	margin-left:90px;

}
#login-webshop{
	padding: 0 0 0 350px;
	width: 103px; 
	height: 42px; 
}

#login-footer{
	margin-left:240px;
	padding: 10px 0 0 0;
	width: 38em;
	height: 50px;
	border-style: solid;
	border-color:black;
	border-width:2px;
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
		<div id="login-button">
			<a href="#"><img src="images/login-btn.png"/></a>
		</div>
	</div>
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