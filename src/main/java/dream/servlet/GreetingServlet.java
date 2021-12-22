package dream.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dream.models.Email;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ArvikV
 * @version 1.0
 * @since 21.12.2021
 */
public class GreetingServlet extends HttpServlet {
    private final List<Email> emails = new CopyOnWriteArrayList<>();

    private static final Gson GSON = new GsonBuilder().create();
    /**
     * При обработке POST запроса производится десериализация модели. Далее объект сохраняется в список.
     * @param req  запрос
     * @param resp ответ
     * @throws ServletException прокидываем сервлетЭксепшн
     * @throws IOException прокидываем иоЭксепшн
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Email email = GSON.fromJson(req.getReader(), Email.class);
        emails.add(email);

        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(email);
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }

    /**
     *При обработке GET запроса происходит сериализация списка добавленных почтовых адресов.
     * @param req запрос
     * @param resp ответ
     * @throws ServletException прокидываем сервлетЭкспешн
     * @throws IOException прокидываем иоЭксепшн
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=utf-8");
        OutputStream output = resp.getOutputStream();
        String json = GSON.toJson(emails);
        resp.setHeader("Access-Control-Allow-Origin", "*");
        output.write(json.getBytes(StandardCharsets.UTF_8));
        output.flush();
        output.close();
    }
}
