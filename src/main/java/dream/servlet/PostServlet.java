package dream.servlet;

import dream.models.Post;
import dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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
        DbStore.instOf().savePost(
                new Post(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        req.getParameter("description"),
                        LocalDateTime.now()
                ));
        resp.sendRedirect(req.getContextPath() + "/post.do");
    }

    /**
     *
     * 1.2 перенаправляем запрос в posts.jsp
     * 1.2 В методe doGet мы загружаем в request список вакансий.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("posts", DbStore.instOf().findAllPosts());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }
}