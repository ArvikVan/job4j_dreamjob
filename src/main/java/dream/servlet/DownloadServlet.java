package dream.servlet;
import dream.properties.Config;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import static java.lang.System.in;

/**
 * @author ArvikV
 * @version 1.0
 * @since 07.12.2021
 */
public class DownloadServlet extends HttpServlet {
    private static final String IMAGE_PATH = Config.getConfig().getProperty("path.images");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        File downloadFile = null;
        for (File file : new File(IMAGE_PATH).listFiles()) {
            if (file.getName().equals(name)) {
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
