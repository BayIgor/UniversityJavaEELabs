<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.ServletContext" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Параметры URL</title>
</head>
<body>
<h1>Значения параметров URL</h1>
<p>Значение параметра URL1: <%= config.getServletContext().getInitParameter("URL1") %></p>
<p>Значение параметра URL2: <%= config.getServletContext().getInitParameter("URL2") %></p>

</body>
</html>
