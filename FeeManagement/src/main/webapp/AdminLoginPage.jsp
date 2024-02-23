<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="AdminLoginPage.css">
    <title>Admin Login</title>
    
</head>
<body>

<header>
    <nav>
        <a href="Welcomepage.html">Home</a>
    </nav>
</header>

<div class="container">
    <form action="admin-login" method="post">
        <h2>Admin Login</h2>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
    </form>
  
    <p style="color: red">
        <% 
            // Display error message if 'error' attribute is set in the request
            String error = (String)request.getAttribute("error");
            if(error != null) {
                out.println(error);
            }
        %>
    </p>
</div>

<footer>
    <p>&copy; 2024 Tuk Tuk College. All rights reserved.</p>
</footer>

</body>
</html>
