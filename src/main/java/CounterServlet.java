import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String reset = req.getParameter("reset");

        res.setContentType("text/html");
        counter += 1;
        res.getWriter().println("<h1>Welcome to the page! You are visitor number " + counter + "!</h1>");
        res.getWriter().println("<p>Add ?reset=yes to the url to reset the counter</p>");

        if (reset.equals("yes")){
            counter =0;
        }
    }
}

