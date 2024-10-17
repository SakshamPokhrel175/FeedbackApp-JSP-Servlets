import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;

@WebServlet("/feedbackservlet")
public class feedbackservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public feedbackservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hi from console");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get form data
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String feedbackMessage = request.getParameter("feedback_message");
	    
	    // Input validation
        if (!isValidEmail(email)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid email format.");
            return;
        }

        if (!isValidPhone(phone)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid phone format.");
            return;
        }

	    // Database connectivity
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    // Display form data in response
	    out.println("<h2>Your form Details</h2>");
	    out.println("<h3>Email address: " + email + "</h3>");
	    out.println("<h3>Phone number: " + phone + "</h3>");
	    out.println("<h3>Feedback message: " + feedbackMessage + "</h3>");
	    
	    // Add a button to go back to index.html
	    out.println("<div class='text-center'>");
	    out.println("<button class='btn btn-primary' onclick=\"window.location.href='/feedback_app/index.jsp'\">Back to Home</button>");
	    out.println("</div>");
	    
	    // Database connection
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");  // exception
	        System.out.println("Driver found");

	        // Provide the actual database name here
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_app", "root", "admin");
	        System.out.println("Connection Success");

	        // Insert feedback into the database
	     	String insertQuery = "INSERT INTO feedback (email, phone, message) VALUES (?, ?, ?)";
	     	PreparedStatement ps  = connection.prepareStatement(insertQuery);
	     	ps.setString(1, email);
	     	ps.setString(2, phone);
	     	ps.setString(3, feedbackMessage);

	        int result = ps.executeUpdate();  // Correct usage of executeUpdate()

	        if (result > 0) {
				out.println("<h3>Feedback submitted successfully!</h3>");
			} else {
				out.println("<h3>Error submitting feedback.</h3>");
			}
		} catch (Exception e) {
			out.println("<h3>Database connection error: " + e.getMessage() + "</h3>");
		}
	}

    // Email validation using regex
	private boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		return emailPattern.matcher(email).matches();
	}

    // Phone validation using regex (assumes phone numbers with 10 digits)
	private boolean isValidPhone(String phone) {
		String phoneRegex = "^[0-9]{10}$";
		Pattern phonePattern = Pattern.compile(phoneRegex);
		return phonePattern.matcher(phone).matches();
	}
}
