<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page 4</title>
</head>
<body>
	<h1>Page 4</h1>
	<% 
		String d1 = (String)request.getAttribute("data1");
		String d2 = (String)request.getAttribute("data2");
	%>
	
	<p>Name    : <%= d1 %></p>
	<p>Subject : <%= d2 %></p>
</body>
</html>