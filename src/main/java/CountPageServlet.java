import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountPageServlet", urlPatterns = "/count")
public class CountPageServlet extends HttpServlet {

    int hitCounter = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter output = resp.getWriter();
        if (req.getParameter("reset") != null) {
            hitCounter = 1;
        }
        output.println("your hit count is: " + hitCounter);
    }
}


