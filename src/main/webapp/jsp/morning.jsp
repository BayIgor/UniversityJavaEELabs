<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Утро</title>
</head>
<body>
<h1>Доброе утро! Это страница "Утро".</h1>
<%
    String message = "Утро";
    System.out.println(message);
    String filePath = "D:\\University\\4Course\\1sem\\InetProg\\LR1-10\\AS_1\\logs\\out.log";

    try {
        // Создаем объект File
        File file = new File(filePath);

        // Проверяем, существует ли файл, и если нет, создаем его
        if (!file.exists()) {
            file.createNewFile();
        }

        // Создаем объект FileWriter для записи данных в файл
        FileWriter fw = new FileWriter(file, true); // true - чтобы данные добавлялись в конец файла

        // Создаем объект BufferedWriter для буферизированной записи
        BufferedWriter bw = new BufferedWriter(fw);

        // Ваш текст для записи
        String dataToWrite = "Полдень";

        // Записываем данные в файл
        bw.write(dataToWrite + "\n");

        // Закрываем BufferedWriter и FileWriter после записи
        bw.close();
        fw.close();
        System.out.println("Данные успешно записаны в файл.");
    } catch (IOException e) {
        System.out.println("Ошибка при записи в файл: " + e.getMessage());
    }
%>
</body>
</html>
