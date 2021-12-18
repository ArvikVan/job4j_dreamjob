package dream.servlet;

import dream.models.User;
import dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ArvikV
 * @version 1.0
 * @since 18.12.2021
 */
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (DbStore.instOf().findByEmailUser(email) != null) {
            req.setAttribute("error", "Email занят");
            req.getRequestDispatcher("reg.jsp").forward(req, res);
        } else {
            DbStore.instOf().saveUser(new User(name, email, password));
            HttpSession session = req.getSession();
            session.setAttribute("user", DbStore.instOf().findByEmailUser(email));
            res.sendRedirect(req.getContextPath() + "/post.do");
        }
    }
}
