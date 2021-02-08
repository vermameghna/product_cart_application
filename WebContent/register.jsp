<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Register as a new User</h1>

<form action="registerController" method="POST">
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
</body>
</html>