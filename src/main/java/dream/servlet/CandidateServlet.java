package dream.servlet;

import dream.models.Candidate;
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
 * Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
 */
public class CandidateServlet extends HttpServlet {
    /**
     * 1.2 Обратите внимание в методе doPost тоже изменен адрес candidates.do
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        DbStore.instOf().saveCandidate(
                new Candidate(
                        Integer.parseInt(request.getParameter("id")),
                                request.getParameter("name"),
                        Integer.parseInt(request.getParameter("city")),
                                LocalDateTime.now())
        );
        response.sendRedirect(request.getContextPath() + "/candidate.do");
    }

    /**
     *
     * 1.2 перенаправляем запрос в candidates.jsp
     * 1.2 В методу doGet мы загружаем в request список candidates
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", DbStore.instOf().findAllCandidates());
        req.setAttribute("cities", DbStore.instOf().findAllCities());
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }
}
