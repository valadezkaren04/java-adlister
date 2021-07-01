import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); // sets the value
        req.setAttribute("name", name); // passed on into the view ; sets up the attribute
        req.getRequestDispatcher("/hello.jsp").forward(req, resp); // fwrd to a jsp ; served by the servlet ; has the attribute replaced
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); // sets the value
        req.setAttribute("name", name); // passed on into the view ; sets up the attribute
        req.getRequestDispatcher("/hello.jsp").forward(req, resp); // fwrd to a jsp ; served by the servlet ; has the attribute
    }
}

