package dream.servlet;

import dream.properties.Config;
import dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author ArvikV
 * @version 1.0
 * @since 14.12.2021
 */
public class DeletePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("posts", DbStore.instOf().findAllPosts());
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String id = req.getParameter("id");
        req.setCharacterEncoding("UTF-8");
        DbStore.instOf().deletePost(Integer.valueOf(id));
        resp.sendRedirect(req.getContextPath() + "/post.do");
    }
}