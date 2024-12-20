import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/video")
public class VideoStreamServlet extends HttpServlet {

    private static final String VIDEO_PATH = "<Video-file-path>"; // Video file path
    private static final String AUDIO_PATH = "Audio-file-path"; // Audio file path

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");

        File file;
        String contentType;
        if ("audio".equals(type)) {
            file = new File(AUDIO_PATH);
            contentType = "audio/mpeg";
        } else {
            file = new File(VIDEO_PATH);
            contentType = "video/mp4";
        }

        try (FileInputStream inputStream = new FileInputStream(file)) {
            response.setContentType(contentType);
            response.setContentLength((int) file.length());

            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }
}
