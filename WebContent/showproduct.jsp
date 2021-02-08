<%@page import="java.util.List"%>
<%@page import="com.productcart.productdao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <%
        List<Product> products = (List<Product>)request.getAttribute("products");
    %>
    <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    </tr>
<%
        for(Product product: products)
        {
            %>
                <tr>
               
                     <td>
                     <%= product.getId()%>
                     </td>
                     
                
                     <td>
                     <%= product.getName()%>
                     </td>
                     
                     
              
                     <td>
                     <%= product.getPrice()%>
                     </td>
                     
                 
                     <td>
                     <%= product.getQuantity()%>
                     </td>
                               
                </tr>
            <% 
        }
    %>
</table>
<a href="home.jsp">Go to HomePage</a>
</body>
</html>