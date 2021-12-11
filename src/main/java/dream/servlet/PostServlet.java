package dream.servlet;

import dream.models.Post;
import dream.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ArvikV
 * @version 1.2
 * @since 05.12.2021
 * загрузка ид в сервлет Integer.valueOf(req.getParameter("id")), req.getParameter("name"))
 */
public class PostServlet extends HttpServlet {
    /**
     * 1.2 братите внимание в методе doPost тоже изменен адрес.
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        MemStore.instOf().save(
                new Post(
                        Integer.parseInt(req.getParameter("id")), req.getParameter("name")));
        resp.sendRedirect(req.getContextPath() + "/post.do");
    }

    /**
     *
     * 1.2 перенаправляем запрос в posts.jsp
     * 1.2 В методe doGet мы загружаем в request список вакансий.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", MemStore.instOf().findAll());
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }
}
