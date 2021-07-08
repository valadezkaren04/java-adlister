import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("isAdmin") != null) {
            response.sendRedirect("/secret-admin-page.jsp");
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = username.equals("admin") && password.equals("password");

        HttpSession session = request.getSession();

        if (isAdmin) {
            session.setAttribute("isAdmin", true);
            response.sendRedirect("/secret-admin-page");
        } else {
            response.sendRedirect("/login");
        }









//        // set the session object to a variable based on the HttpSession class.
//        HttpSession session = request.getSession();
//
//        String darkMode = request.getParameter("color");
//
//        // set the dark theme attribute on the session so that it gets remembered every time we log in.
//        session.setAttribute("darkMode", darkMode);
//
//        // on a different servlet (profile page).
//        // with our getAttribute method, our return is always a generic Object type.
//        // therefore we need to explicitly cast the object to the correct type.
//        session.getAttribute("darkMode");
//        String darkSelected = (String) session.getAttribute("darkMode");
//
//        // to remove an attribute
//        session.removeAttribute("darkMode");
//
//        // destroys the session
//        session.invalidate();


    }
}
