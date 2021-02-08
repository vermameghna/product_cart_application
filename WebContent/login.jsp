<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles/login.css">

</head>
<body>
${param.error}<br>
${param.message }<br>


<div id="login-form">
<form action="controller" method="POST">
<table>
<tr>
<td>Enter Name:</td> 
<td><input type="text" name="username"/></td> 
</tr>

<tr>
<td>Enter Password:</td> 
<td><input type="password" name="password"/></td> 
</tr>
</table>

<input type="submit"/>
</form>


<a href="register.jsp">Register new User?</a>
</div>
</body>
</html>