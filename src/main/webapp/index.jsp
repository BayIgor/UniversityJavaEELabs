<%@ page import="javax.naming.Context" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Приветствие и Таблица</title>
</head>
<body>
<%
    // Получаем текущее время
    java.util.Date currentDate = new java.util.Date();
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.setTime(currentDate);

    int hourOfDay = calendar.get(java.util.Calendar.HOUR_OF_DAY);

    // Определяем приветствие в зависимости от времени суток
    String greeting;
    String pageToInclude;

    if (hourOfDay >= 0 && hourOfDay < 6) {
        greeting = "Доброй ночи";
        pageToInclude = "jsp/night.jsp";
    } else if (hourOfDay >= 6 && hourOfDay < 10) {
        greeting = "Доброе утро";
        pageToInclude = "jsp/morning.jsp";
    } else if (hourOfDay >= 10 && hourOfDay < 18) {
        greeting = "Добрый день";
        pageToInclude = "/LR4/afternoon";
    } else {
        greeting = "Добрый вечер";
        pageToInclude = "jsp/evening.jsp";
    }
%>
<%--<form action="<%= pageToInclude %>" method="get">--%>
<%--    <input type="submit" value="Press">--%>
<%--</form>--%>
<%--<jsp:include page='<%= pageToInclude %>'/>--%>
<jsp:forward page='<%= pageToInclude %>'/>
<h1><%= greeting %>, Igor!</h1>
<table border="1">
    <tr>
        <th>Дата</th>
        <th>День недели</th>
    </tr>
    <%
        // Генерируем таблицу с датами и номерами дней недели
        for (int i = 0; i < 7; i++) {
            // Форматируем дату в формат dd.mm.yyyy
            String formattedDate = String.format("%td.%tm.%tY", calendar, calendar, calendar);

            // Получаем номер дня недели (1-понедельник, 2-вторник и т.д.)
            int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);

            // Выводим данные в таблицу
    %>
    <tr>
        <td><%= formattedDate %></td>
        <td><%= dayOfWeek %></td>
    </tr>
    <%
            // Увеличиваем дату на один день
            calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
        }
    %>
</table>
<a href="/AS_1/jsp/Ttt.jsp">Перейти к Ttt.jsp</a>
</body>
</html>
