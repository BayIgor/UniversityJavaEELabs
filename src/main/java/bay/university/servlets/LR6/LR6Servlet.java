package bay.university.servlets.LR6;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LR6")
public class LR6Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getParameter("urln")!=null) {
            int urln = Integer.parseInt(req.getParameter("urln"));
            ServletContext sc = getServletContext();
            switch (urln) {
                case 1: {
                    req.getRequestDispatcher(sc.getInitParameter("URL1")).forward(req, res);
                    break;
                }
                case 2: {
                    req.getRequestDispatcher(sc.getInitParameter("URL2")).forward(req, res);
                    break;
                }
                default: {
                    res.getWriter().println("parameter URLn not found");
                    break;
                }
            }
        }
        else {
            res.getWriter().println("parameter URLn not found");
        }
    }
}
