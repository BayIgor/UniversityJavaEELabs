package bay.university.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class LR3Servlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("GGG Service");

        String method = req.getMethod();

        if ("GET".equals(method)) {
            // Обработка GET-запроса
            doGet(req, res);
        } else if ("POST".equals(method)) {
            doPost(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GetGgg");
        String name = request.getParameter("name");
        String lastN = request.getParameter("lastN");

        String result = "Received name: " + name + ", lastN: " + lastN;

        response.setContentType("text/plain");
        response.getWriter().write(result);

        //request.getRequestDispatcher("/html/education.html").forward(request, response);
        //response.sendRedirect("/AS_1/html/education.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastN = request.getParameter("lastN");

        String result = "Received name: " + name + ", lastN: " + lastN;

        response.setContentType("text/plain");
        response.getWriter().write(result);
    }
}
