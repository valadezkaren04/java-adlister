import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            boolean idAdmin = req.getParameter("isAdmin").equalsIgnoreCase("yes");

            if (idAdmin){
                out.println("<h1>Welcome home, Admin </h1>");
            } else {
                resp.sendRedirect("/hello-world");
            }
        } catch (NullPointerException npe){
            resp.sendRedirect("/hello-world");
        }
    }
}
