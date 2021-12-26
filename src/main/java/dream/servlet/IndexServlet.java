package dream.servlet;

import dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ArvikV
 * @version 1.0
 * @since 06.12.2021
 */
public class IndexServlet extends HttpServlet {
    /**
     * перенаправляем запрос в index.jsp
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", DbStore.instOf().findLastDayPosts());
        req.setAttribute("candidates", DbStore.instOf().findLastDayCandidates());
        req.setAttribute("cities", DbStore.instOf().findAllCities());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
