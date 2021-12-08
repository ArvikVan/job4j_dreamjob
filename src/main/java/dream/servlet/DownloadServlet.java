package dream.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author ArvikV
 * @version 1.0
 * @since 07.12.2021
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        File downloadFile = null;
        for (File file : Objects.requireNonNull(
                new File("/home/arvik/IdeaProjects/job4j_dreamjob/src/main/java/dream/images").listFiles())) {
            if (name.equals(file.getName())) {
                downloadFile = file;
                break;
            }
        }
        try (FileInputStream stream = new FileInputStream(downloadFile)) {
            resp.getOutputStream().write(stream.readAllBytes());
            resp.setContentType("application/octet-stream");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
        }
    }
}
