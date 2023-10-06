package bay.university.servlets.LR5;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ttt")
public class LR5Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Устанавливаем кодировку для корректного чтения параметров
        request.setCharacterEncoding("UTF-8");

        // Получаем значения параметров из запроса
        String surname = request.getParameter("surname");
        String lastname = request.getParameter("lastname");
        String sex = request.getParameter("sex");

        // Генерируем HTTP-ответ
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<html><head><title>Результат</title></head><body>");
        response.getWriter().println("<h2>Данные из формы:</h2>");
        response.getWriter().println("<p>Фамилия: " + surname + "</p>");
        response.getWriter().println("<p>Имя: " + lastname + "</p>");
        response.getWriter().println("<p>Пол: " + sex + "</p>");
        response.getWriter().println("</body></html>");
    }
}

