<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import=" java.util.*"%>
    <%@page import="com.gmu.edu.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		ArrayList<StatDetails> details =(ArrayList<StatDetails>)request.getSession().getAttribute("statList");
		
		
			for(int i=0;i<details.size();i++) 
			{
			String name = details.get(i).getName();
			String email=details.get(i).getEmail();
			int wins=details.get(i).getWins();
			int loss=details.get(i).getLoss();
			
		%>	
<table border="3" cellpadding="5" cellspacing="0" align="center">
<tr><td><b>Name</b>:<%= name %></td> </tr>
<tr><td><b>Email</b>: <%= email %></td></tr>
<tr><td><b>Wins</b>: <%= wins %></td></tr>
<tr><td><b>Loss</b>: <%= loss %></td></tr>
<%
			}
		%>
</table>

</body>
</html>