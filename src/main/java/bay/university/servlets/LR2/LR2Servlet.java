package bay.university.servlets.LR2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

@WebServlet
public class LR2Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init");
    }

    @Override
    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        //Task 7,8
        String method = req.getMethod();
        String serverName = req.getServerName();
        String ip = req.getLocalAddr();

        out.println("service  " + method);
        out.println(ip);
        out.println(serverName);

        if ("GET".equals(method)) {
            // Обработка GET-запроса
            doGet(req, res);
            //req.getRequestDispatcher("/GoGgg").forward(req, res);
            //res.sendRedirect("/AS_1/GoGgg");
        } else if ("POST".equals(method)) {
            System.out.println("PostSss");
            //req.getRequestDispatcher("/GoGgg").forward(req, res);
            //res.sendRedirect("/AS_1/GoGgg");
            doPost(req, res);
        }
        System.out.println("service Sss");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("doGet");
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        String allString = request.getRequestURI();
//
//        PrintWriter out = response.getWriter();
//        out.println("doGet  " + firstname + "  " + lastname);
//        out.println(allString);
//

        //Task7 LR3
        // URL адрес сервлета Ggg
        String gggServletUrl = "http://localhost:8080/AS_1/GoGgg"; // Замените на соответствующий URL

        // Создание объекта HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        // Создание GET-запроса
        try {
            URIBuilder builder = new URIBuilder(gggServletUrl);
            builder.setParameter("name", "Igor");
            builder.setParameter("lastN", "Bay");
            HttpGet httpGet = new HttpGet(builder.build());

            // Выполнение GET-запроса
            HttpResponse httpResponse = httpClient.execute(httpGet);

            // Обработка ответа
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(httpResponse.getEntity());

            //Вывод обработки ответа, вывод переданных параметров
            response.setStatus(statusCode);
            response.getWriter().write(responseBody);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gggServletUrl = "http://localhost:8080/AS_1/GoGgg"; // Замените на соответствующий URL

        // Создание объекта HttpClient
        HttpClient httpClient = HttpClients.createDefault();

        // Создание GET-запроса
        try {
            URIBuilder builder = new URIBuilder(gggServletUrl);
            builder.setParameter("name", "Igor");
            builder.setParameter("lastN", "Bay");
            HttpPost httpPost = new HttpPost(builder.build());

            // Выполнение GET-запроса
            HttpResponse httpResponse = httpClient.execute(httpPost);

            // Обработка ответа
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String responseBody = EntityUtils.toString(httpResponse.getEntity());

            //Вывод обработки ответа, вывод переданных параметров
            response.setStatus(statusCode);
            response.getWriter().write(responseBody);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
