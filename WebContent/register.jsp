<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Registration Page</title>
</head>
<body>
<h1>Welcome to Bridge Card Game</h1>
<h2>Registration Page</h2>
<form action="register" method="post">
<table>
<tr><td>Name:</td>
	<td><input type="text" id="name" name="name"></td>
	<td><span class="error">${errors.name}</span></td>
</tr>
<tr><td>City:</td>
	<td><input type="text" id="city" name="city"></td>
</tr>
<tr><td>Email:</td>
	<td><input type="text" id="email" name="email"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" id="password" name="password"></td>
</tr>
<tr>

<td><input type="submit" id="submit" name="submit"></td>
</tr>
</table>
</form>
</body>
</html>