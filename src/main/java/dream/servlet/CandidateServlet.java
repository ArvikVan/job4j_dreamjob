package dream.servlet;

import dream.models.Candidate;
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
 * Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
 */
public class CandidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Store.instOf().saveCandidate(
                new Candidate(
                        Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
        response.sendRedirect(request.getContextPath() + "/candidates.jsp");
    }
}
