package dream.servlet;

import dream.models.Post;
import dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ArvikV
 * @version 1.1
 * @since 05.12.2021
 * загрузка ид в сервлет Integer.valueOf(req.getParameter("id")), req.getParameter("name"))
 */
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Store.instOf().save(
                new Post(
                        Integer.parseInt(req.getParameter("id")), req.getParameter("name")));
        resp.sendRedirect(req.getContextPath() + "/posts.jsp");
    }
}
