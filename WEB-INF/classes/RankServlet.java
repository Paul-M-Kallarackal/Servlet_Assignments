import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class RankServlet extends HttpServlet {

    // Precomputed data of marks and ranks with registration numbers
    private static final HashMap<Integer, String[]> data = new HashMap<Integer, String[]>() {{
        put(1001, new String[]{"90", "1"});
        put(1002, new String[]{"85", "2"});
        put(1003, new String[]{"80", "3"});
        put(1004, new String[]{"75", "4"});
        put(1005, new String[]{"70", "5"});
        put(1006, new String[]{"65", "6"});
        put(1007, new String[]{"60", "7"});
        put(1008, new String[]{"55", "8"});
        put(1009, new String[]{"50", "9"});
        put(1010, new String[]{"45", "10"});
    }};

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the registration number from the HTML form
        String regNumber = request.getParameter("regNumber");
        
        // Parse the registration number as an integer
        int regNum = Integer.parseInt(regNumber);
        
        // Check if the registration number exists in the data map
        if (data.containsKey(regNum)) {
            // Get the marks and rank for the given registration number
            String[] marksAndRank = data.get(regNum);
            String marks = marksAndRank[0];
            String rank = marksAndRank[1];

            // Write the response
            PrintWriter out = response.getWriter();
            out.println("Registration number: " + regNumber);
            out.println("Marks: " + marks);
            out.println("Rank: " + rank);
        } else {
            // Write an error response if the registration number is not found in the data map
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Registration number not found");
        }
    }
}
