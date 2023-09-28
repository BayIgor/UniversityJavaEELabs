package bay.university.servlets;

import bay.university.wtf.CBean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Ccc")
public class CccServlet extends HttpServlet {
    private CBean cBean;

    @Override
    public void init() throws ServletException {
        super.init();

        // Создание объекта CBean при инициализации сервлета
        cBean = new CBean();

        // Получение контекста приложения
        ServletContext context = getServletContext();

        // Запись объекта CBean в атрибут контекста
        context.setAttribute("atrCBean", cBean);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("/jsp/Ccc.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("/jsp/Ccc.jsp").forward(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cBeanParam = request.getParameter("CBean");
        if (cBeanParam != null && cBeanParam.equals("new")) {
            // Если параметр CBean равен "new", создать новый объект CBean
            cBean = new CBean();
            // Обновить атрибут контекста
            getServletContext().setAttribute("atrCBean", cBean);
        }
        String value1 = request.getParameter("Value1");
        String value2 = request.getParameter("Value2");
        String value3 = request.getParameter("Value3");

        if (value1 != null) {
            cBean.setValue1(value1);
        }
        if (value2 != null) {
            cBean.setValue2(value2);
        }
        if (value3 != null) {
            cBean.setValue3(value3);
        }
    }
}
