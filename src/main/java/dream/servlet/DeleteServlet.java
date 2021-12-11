package dream.servlet;

import dream.properties.Config;
import dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author ArvikV
 * @version 1.0
 * @since 08.12.2021
 */
public class DeleteServlet extends HttpServlet {
    private static final String IMAG_EPATH = Config.getConfig().getProperty("path.images");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("candidates", Store.instOf().findAllCandidates());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String id = req.getParameter("id");
        req.setCharacterEncoding("UTF-8");
        Store.instOf().deleteCandidate(Integer.parseInt(req.getParameter("id")));
        File file = new File(IMAG_EPATH.concat(id)
                + ".png");
        file.delete();
        resp.sendRedirect(req.getContextPath() + "/candidate.do");
    }

}
