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
    <th>Remove links</th>
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
                     
                     <td>
                     <a href="ProductController.do?action=updateById&id=<%= product.getId()%>">Update this product</a>
                     </td>
                       
                </tr>
                
                
            <% 
        }
    %>
</table>
<a href="home.jsp">Want to go to HomePage? Click Here!</a>
</body>
</html>