<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles/home.css">
</head>
<body>

  <h1>Welcome ${user.username} to the home page!</h1>
  <div class="btn">
  <a href="ProductController.do?action=show"><button>Show all products</button></a>
  </div>
  
  
  <div class="btn">
  <a href="ProductController.do?action=add"><button>Add a product</button></a>
  </div>
  
  
  <div class="btn">
  <a href="ProductController.do?action=remove"><button>Remove a product</button></a>
  </div>
  
  <div class="btn">
  <a href="ProductController.do?action=update"><button>Update a product</button></a>
  </div>
  
  
  <div class="btn-red">
  <a href="LogoutController"><button>Logout</button></a>
  </div>
  
  
  
  
</body>
</html>