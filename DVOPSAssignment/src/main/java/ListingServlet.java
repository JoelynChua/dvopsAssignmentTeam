

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ListingServlet
 */
@WebServlet("/ListingServlet")
public class ListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/proxylisting";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";

	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	private static final String INSERT_LISTING_SQL = "INSERT INTO ProxyListing" + " (listingId, listingName, listingPrice, listingCountry, listingRemarks, listingImage, userId ) "
			+ "VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_LISTING_BY_ID = "select listingId, listingName, listingPrice, listingCountry, listingRemarks, listingImage, userId from proxylisting where listingId =?";
	private static final String SELECT_ALL_LISTING = "select * from proxylisting ";
	private static final String DELETE_LISTING_SQL = "delete from ProxyListing where listingId = ?;";
	//private static final String UPDATE_LISTING_SQL = "update proxylisting set listingId = ?, listingName= ?, listingPrice =?, listingCountry =?, listingRemarks =?, listingImage =?, userId =? where listingId = ?;";
	private static final String UPDATE_LISTING_SQL = "update proxylisting set listingName = ?, listingPrice =?, listingCountry = ?,listingRemarks =?,listingImage =? where listingId = ?;";
	
	//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
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
    public ListingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ListingServlet/delete":
				deleteListing(request, response);
				break;
			case "/ListingServlet/edit":
				showEditForm(request, response);
				break;
			case "/ListingServlet/update":
				updateListing(request, response);
				break;	
			case "/ListingServlet/viewListings":
				viewAllListing(request, response);
				break;
			case "/ListingServlet/details":
				showListingDetails(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	
	//Retrieve Listing
	//Step 5: viewAllListing function to connect to the database and retrieve all users records
	private void viewAllListing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Listing> listings = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LISTING);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String listingId = rs.getString("listingId");
				String listingName = rs.getString("listingName");
				String listingPrice = rs.getString("listingPrice");
				String listingCountry = rs.getString("listingCountry");
				String listingRemarks = rs.getString("listingRemarks");
				String listingImage = rs.getString("listingImage");
				String userId = rs.getString("userId");
				listings.add(new Listing(listingId, listingName, listingPrice, listingCountry, listingRemarks,
						listingImage, userId));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp
		request.setAttribute("viewAllListing", listings);
		request.getRequestDispatcher("/viewListings.jsp").forward(request, response);
	}
	
	
	//Retrieve listing details
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showListingDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String listingId = request.getParameter("listingId");
		Listing currentListing = new Listing("", "", "", "", "", "", "");

		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LISTING_BY_ID);) {
			    preparedStatement.setString(1, listingId);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				listingId = rs.getString("listingId");
				String listingName = rs.getString("listingName");
				String listingPrice = rs.getString("listingPrice");
				String listingCountry = rs.getString("listingCountry");
				String listingRemarks = rs.getString("listingRemarks");
				String listingImage = rs.getString("listingImage");
				String userId = rs.getString("userId");
				currentListing = new Listing(listingId, listingName, listingPrice, listingCountry,
						listingRemarks, listingImage, userId);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("listing", currentListing);
		request.getRequestDispatcher("/listingDetails.jsp").forward(request, response);
	}
	
	//edit form
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String listingId = request.getParameter("listingId");
		Listing currentListing = new Listing("", "", "", "", "", "", "");

		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LISTING_BY_ID);) {
			    preparedStatement.setString(1, listingId);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				listingId = rs.getString("listingId");
				String listingName = rs.getString("listingName");
				String listingPrice = rs.getString("listingPrice");
				String listingCountry = rs.getString("listingCountry");
				String listingRemarks = rs.getString("listingRemarks");
				String listingImage = rs.getString("listingImage");
				String userId = rs.getString("userId");
				currentListing = new Listing(listingId, listingName, listingPrice, listingCountry,
						listingRemarks, listingImage, userId);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("listing", currentListing);
		request.getRequestDispatcher("/editListing.jsp").forward(request, response);
	}
	
	//Update listing
	private void updateListing(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		//String oriId = request.getParameter("oriId");
		//String oriListingName = request.getParameter("oriListingName");
		String orilistingId = request.getParameter("orilistingId");
		String listingName = request.getParameter("listingName");
		String listingPrice = request.getParameter("listingPrice");
		String listingCountry = request.getParameter("listingCountry");
		String listingRemarks = request.getParameter("listingRemarks");
		String listingImage = request.getParameter("listingImage");
		//String userId = request.getParameter("userId");;
		// System.out.println (listingCountry); //takes in input
		

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_LISTING_SQL);) {
					//statement.setString(1, orilistingId);
			        //Impt: Order of the statement matter
					statement.setString(1, listingName);
					statement.setString(2, listingPrice);
					statement.setString(3, listingCountry);
					statement.setString(4, listingRemarks);
					statement.setString(5, listingImage);
					statement.setString(6, orilistingId);
					//statement.setString(7, userId);
					//statement.setString(7, oriListingName);
					int i = statement.executeUpdate();
					//System.out.println (statement);
					//System.out.println (i);
		}

		// Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
		response.sendRedirect("http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings");
	}
	
	//delete
	private void deleteListing(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
			//Step 1: Retrieve value from the request
		    String listingId = request.getParameter("listingId");;
			 //Step 2: Attempt connection with database and execute delete user SQL query
			 try (Connection connection = getConnection(); PreparedStatement statement =
			connection.prepareStatement(DELETE_LISTING_SQL);) {
			 statement.setString(1, listingId);
			 int i = statement.executeUpdate();
			 }
			 //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
			 response.sendRedirect("http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings");
			}
	
	

	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
