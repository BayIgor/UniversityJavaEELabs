package bay.university.servlets.LR4;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jjj")
public class LR4Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получаем текущее время
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        // Определяем, какую страницу отобразить в зависимости от времени суток
        String pageToInclude = null;

        if (hourOfDay >= 0 && hourOfDay < 6) {
            pageToInclude = "jsp/night.jsp";
        } else if (hourOfDay >= 6 && hourOfDay < 12) {
            pageToInclude = "jsp/morning.jsp";
        } else if (hourOfDay >= 12 && hourOfDay < 18) {
            pageToInclude = "jsp/afternoon.jsp";
        } else {
            pageToInclude = "jsp/evening.jsp";
        }

//        // *** task11 ***
//        // Выполняем переадресацию на выбранную JSP-страницу
        response.sendRedirect(pageToInclude);
//        // **************

        // *** task12 ***
        // URL адрес JSP-страницы, которую вы хотите запросить
//        String jspUrl = "http://localhost:8080/AS_1/" + pageToInclude; // Замените на соответствующий URL
//
//        // Создание объекта HttpClient
//        HttpClient httpClient = HttpClients.createDefault();
//
//        // Создание GET-запроса к JSP-странице
//        HttpGet httpGet = new HttpGet(jspUrl);
//
//        // Выполнение GET-запроса
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//
//        // Получение содержимого ответа
//        String responseBody = EntityUtils.toString(httpResponse.getEntity());
//
//        // Отправляем содержимое ответа в окно браузера
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println(responseBody);
        // **************
    }
}
