import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

  private String[] myArray = {"Apple", "Banana", "Cherry"};

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");

    // get input from form
    int index = Integer.parseInt(request.getParameter("index"));
      response.getWriter().println("<h1>Value at index " + index + " is: " + myArray[index] + "</h1>");
    }
}
