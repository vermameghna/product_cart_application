<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ProductController.do?action=update&id=${product.id}" method="POST">
<table>
<tr>
<td>Enter Product Name:</td> 
<td><input type="text" name="product-name" value="${product.name}" readonly/></td> 
</tr>

<tr>
<td>Enter Price:</td> 
<td><input type="text" name="price" value="${product.price}" /></td> 
</tr>

<tr>
<td>Enter Quantity:</td> 
<td><input type="text" name="quantity" value="${product.quantity}"/></td> 
</tr>
</table>

<input type="submit"/>
</form>
<a href="home.jsp">Want to go to HomePage? Click Here!</a>
</body>
</html>