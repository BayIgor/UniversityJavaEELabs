package bay.university.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/afternoon")
public class afternoonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Устанавливаем кодировку и тип содержимого для HTTP-ответа
        response.setContentType("text/html;charset=UTF-8");

        // Получаем объект PrintWriter для записи в HTTP-поток
        PrintWriter out = response.getWriter();

        // Формируем сообщение
        String message = "Servlet: Good afternoon";

        // Выводим сообщение в HTTP-поток
        out.println("<html>");
        out.println("<head><title>Afternoon Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
