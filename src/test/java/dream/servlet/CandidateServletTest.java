package dream.servlet;

import dream.models.Candidate;
import dream.models.Post;
import dream.store.DbStore;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * @author ArvikV
 * @version 1.0
 * @since 19.12.2021
 */
public class CandidateServletTest {
    @Test
    public void whenCreateCandidate() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("candidate");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findByIdCandidate(0);
        assertThat(candidate, nullValue());
    }
}