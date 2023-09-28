<%@ page import="bay.university.wtf.CBean" %>

<%
    // Извлечение ссылки на объект CBean из атрибута контекста
    CBean cBean = (CBean) application.getAttribute("atrCBean");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Ccc Page</title>
</head>
<body>
<h1>Values from CBean:</h1>
<ul>
    <li>Value1: <%= cBean.getValue1() %></li>
    <li>Value2: <%= cBean.getValue2() %></li>
    <li>Value3: <%= cBean.getValue3() %></li>
</ul>
</body>
</html>
