package dream.servlet;

import dream.models.Candidate;
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
 * Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
 */
public class CandidateServlet extends HttpServlet {
    /**
     * 1.2 Обратите внимание в методе doPost тоже изменен адрес candidates.do
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MemStore.instOf().saveCandidate(
                new Candidate(
                        Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
        response.sendRedirect(request.getContextPath() + "/candidate.do");
    }

    /**
     *
     * 1.2 перенаправляем запрос в candidates.jsp
     * 1.2 В методу doGet мы загружаем в request список candidates
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", MemStore.instOf().findAllCandidates());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }
}
