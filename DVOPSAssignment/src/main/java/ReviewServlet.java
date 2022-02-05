
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	//c41.r_cGp3GVuPwC

	//CRUD SQL Statements
	private static final String INSERT_REVIEW_SQL = "INSERT INTO REVIEWS" + " (reviewID ,userID, rating, review) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_REVIEW_BY_ID = "SELECT reviewID, userID, rating, review FROM reviews WHERE reviewID =?";
	private static final String SELECT_ALL_REVIEWS = "SELECT * FROM REVIEWS ";
	private static final String DELETE_REVIEW_SQL = "DELETE FROM REVIEWS WHERE reviewID = ?;";
	private static final String UPDATE_REVIEW_SQL = "UPDATE REVIEWS SET reviewID = ?, userID= ?, rating =?, review =? WHERE reviewID = ?;";


	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ReviewServlet/delete":
				deleteReview(request, response);
				break;
			case "/ReviewServlet/edit":
				showEditForm(request, response);
				break;
			case "/ReviewServlet/update":
				updateReview(request, response);
				break;
			case "/ReviewServlet/dashboard":
				listReviews(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);

	}

	// Step 5: listReviews function to connect to the database and retrieve all reviews
	// records
	private void listReviews(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Review> reviews = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEWS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String reviewID = rs.getString("reviewID");
				String userID = rs.getString("userID");
				String rating = rs.getString("rating");
				String review = rs.getString("review");
				reviews.add(new Review(reviewID, userID, rating, review));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the reviews list into the listUsers attribute to be pass to the
		// reviewManagement.jsp
		request.setAttribute("listReviews", reviews);
		request.getRequestDispatcher("/reviewManagement.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing review data and redirect
	// to review edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String reviewID = request.getParameter("reviewID");
		Review existingReview = new Review("", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			preparedStatement.setString(1, reviewID);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				reviewID = rs.getString("reviewID");
				String userID = rs.getString("userID");
				String rating = rs.getString("rating");
				String review = rs.getString("review");
				existingReview = new Review(reviewID, userID, rating, review);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingReview to request and serve up the reviewEdit form
		request.setAttribute("review", existingReview);
		request.getRequestDispatcher("/reviewEdit.jsp").forward(request, response);
	}

	// method to update the review table base on the form data
	private void updateReview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriReviewID = request.getParameter("oriReviewID");
		String reviewID = request.getParameter("reviewID");
		String userID = request.getParameter("userID");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		// Step 2: Attempt connection with database and execute update review SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REVIEW_SQL);) {
			statement.setString(1, reviewID);
			statement.setString(2, userID);
			statement.setString(3, rating);
			statement.setString(4, review);
			statement.setString(5, oriReviewID);
			int i = statement.executeUpdate();
		}

		response.sendRedirect("http://localhost:8080/DVOPSAssignment/ReviewServlet/dashboard");
	}

	// method to delete review
	private void deleteReview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String reviewID = request.getParameter("reviewID");
		// Step 2: Attempt connection with database and execute delete review SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEW_SQL);) {
			statement.setString(1, reviewID);
			int i = statement.executeUpdate();
			//console.log();
		}
		// Step 3: redirect back to reviewServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8080/DVOPSAssignment/ReviewServlet/dashboard");
	}

}
