package bay.university.servlets.LR7;

import bay.university.wtf.CBean;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        HttpSession session = request.getSession(true); // Получаем или создаем сессию

        if (cBeanParam != null && cBeanParam.equals("new")) {
            cBean = new CBean();
            getServletContext().setAttribute("atrCBean", cBean);
        }
        else {
            //Task 7.1
//            cBean = (CBean) getServletContext().getAttribute("atrCBean");

            //Task 7.3
            if (session.getAttribute(session.getId()) != null) {
                cBean = (CBean) session.getAttribute(session.getId());
            } else {
                cBean = new CBean();
            }
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

        session.setAttribute(session.getId(), cBean);
//      request.setAttribute("cBean", cBean);
    }
}
