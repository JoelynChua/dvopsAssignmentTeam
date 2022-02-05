

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addReview
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		        HttpSession session = request.getSession();
				response.setContentType("text/html"); // Step 1: Initialize a PrintWriter object to return the html values via
														// the response
				PrintWriter out = response.getWriter(); // Step 2: retrieve the four parameters from the request from the web
														// form
				String c = request.getParameter("reviewID");
				Integer n = (Integer)session.getAttribute("user_id");
				String p = request.getParameter("rating");
				String e = request.getParameter("review");
				// Step 3: attempt connection to database using JDBC, you can change the
				// username and password accordingly using the phpMyAdmin > User Account
				// dashboard
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "password"); //c41.r_cGp3GVuPwC
					// Step 4: implement the sql query using prepared statement
					// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
					PreparedStatement ps = con.prepareStatement("insert into REVIEWS values(?,?,?,?)");
					// Step 5: parse in the data retrieved from the web form request into the
					// prepared statement accordingly
					ps.setString(1, c);
					ps.setInt(2, n);
					ps.setString(3, p);
					ps.setString(4, e); // Step 6: perform the query on the database using the prepared statement
					int i = ps.executeUpdate(); // Step 7: check if the query had been successfully execute, return “You are
												// successfully registered” via the response,
					if (i > 0) {
						PrintWriter writer = response.getWriter();
						writer.println("<h1>" + "Review Added!" + "</h1>");
						writer.close();
						System.out.println(" At Line AddReviewServlet.java Line 75. Review added with User id : " + (Integer)session.getAttribute("user_id") );
					}
				} // Step 8: catch and print out any exception
				catch (Exception exception) {
					System.out.println(exception);
					out.close();
				}
		doGet(request, response);
	}

}
