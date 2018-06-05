import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String message = "";

            boolean success = username.equals("admin") && password.equals("password");

            if (success){
                request.getSession().setAttribute("user", username);
                request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
            } else {
                message ="Incorrect username or password. Please try again";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
    }
}

