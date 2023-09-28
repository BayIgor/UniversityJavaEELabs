<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="mytags" uri="/WEB-INF/mytags/TagLib.tld" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ttt Page</title>
</head>
<body>
<mytags:dossier action="/AS_1/Ttt">
    <mytags:surname/>
    <mytags:lastname/>
    <mytags:sex maleLabel="Male" femaleLabel="Female"/>
    <mytags:submit okLabel="OK" cancelLabel="Cancel"/>
</mytags:dossier>
</body>
</html>
