<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page 8</title>
<style>
ul {
	font-size:20px;
}
</style>
</head>
<body>
	<h1>Page 8</h1>
	<% 
		String d1 = (String)request.getAttribute("data1");
		String d2 = (String)request.getAttribute("data2");
		String d3 = (String)request.getAttribute("data3");
		String d4 = (String)request.getAttribute("data4");
	%>
	
	<ul><%= d1 %>
		<li><%= d2 %></li>
		<li><%= d3 %></li>
		<li><%= d4 %></li>
	</ul>
	
</body>
</html>