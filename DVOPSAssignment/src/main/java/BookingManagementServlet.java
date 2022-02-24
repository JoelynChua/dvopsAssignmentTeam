import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cruds.model.booking;

/**
 * Servlet implementation class BookingManagementServlet
 */
@WebServlet("/BookingManagementServlet")
public class BookingManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  //Step 1: Prepare list of variables used for database connections
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";
    //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
    private static final String INSERT_BOOKINGS_SQL = "INSERT INTO Booking" + "(name, card, cvCode, date, phone, location) VALUES " + " (?, ?, ?, ?, ?);";
    private static final String SELECT_BOOKING_BY_ID = "select name,card,cvCode,date,phone,location from Booking where name =?";
    private static final String SELECT_ALL_BOOKINGS = "select * from Booking ";
    private static final String DELETE_BOOKINGS_SQL = "delete from Booking where name = ?;";
    private static final String UPDATE_BOOKINGS_SQL = "update Booking set name = ?,card= ?, cvCode =?,date =?, phone=?, location=? where name = ?;";
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
    
  //Step 5: listBookings function to connect to the database and retrieve all users records
    private void listBookings(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException
    {
    List <booking> bookings = new ArrayList <>();
     try (Connection connection = getConnection();
     // Step 5.1: Create a statement using connection object
     PreparedStatement preparedStatement =
    connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
     // Step 5.2: Execute the query or update query
     ResultSet rs = preparedStatement.executeQuery();
     // Step 5.3: Process the ResultSet object.
     while (rs.next()) {
     String name = rs.getString("name");
     String card = rs.getString("card");
     String cvCode = rs.getString("cvCode");
     String date = rs.getString("date");
     String phone = rs.getString("phone");
     String location = rs.getString("location");
     bookings.add(new booking(name, card, cvCode, date, phone, location));
     }
     } catch (SQLException e) {
     System.out.println(e.getMessage());
     }
    // Step 5.4: Set the users list into the listUsers attribute to be pass to the BookingManagement.jsp
    request.setAttribute("listBookings", bookings);
    request.getRequestDispatcher("/BookingManagement.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/BookingManagementServlet/delete":
		 deleteBooking(request, response);
		 break;
		 case "/BookingManagementServlet/edit":
		 showEditForm(request, response);
		 break;
		 case "/BookingManagementServlet/update":
		 updateBooking(request, response);
		 break;
		 case "/BookingManagementServlet/dashboard":
		 listBookings(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		 response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
	//get parameter passed in the URL
	String name = request.getParameter("name");
	booking existingBooking = new booking("", "", "", "","","");
	// Step 1: Establishing a Connection
	try (Connection connection = getConnection();
	// Step 2:Create a statement using connection object
	PreparedStatement preparedStatement =
	connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
	preparedStatement.setString(1, name);
	// Step 3: Execute the query or update query
	ResultSet rs = preparedStatement.executeQuery();
	// Step 4: Process the ResultSet object
	while (rs.next()) {
	name = rs.getString("name");
	String card = rs.getString("card");
	String cvCode = rs.getString("cvCode");
	String date = rs.getString("date");
	String phone = rs.getString("phone");
	String location = rs.getString("location");
	existingBooking = new booking(name, cvCode, card, date, phone, location);
	}
	} catch (SQLException e) {
	System.out.println(e.getMessage());
	}
	//Step 5: Set existingUser to request and serve up the bookingEdit form
	request.setAttribute("booking", existingBooking);
	request.getRequestDispatcher("/BookingEdit.jsp").forward(request, response);
	}
	
	//method to update the user table base on the form data
	private void updateBooking(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	String oriName = request.getParameter("oriName");
	 String name = request.getParameter("name");
	 String card = request.getParameter("card");
	 String cvCode = request.getParameter("cvCode");
	 String date = request.getParameter("date");
	 String phone = request.getParameter("phone");
	 String location = request.getParameter("location");

	 //Step 2: Attempt connection with database and execute update user SQL query
	 try (Connection connection = getConnection(); PreparedStatement statement =
	connection.prepareStatement(UPDATE_BOOKINGS_SQL);) {
	 statement.setString(1, name);
	 statement.setString(2, card);
	 statement.setString(3, cvCode);
	 statement.setString(4, date);
	 statement.setString(5, phone);
	 statement.setString(6, location);
	 statement.setString(7, oriName);
	 int i = statement.executeUpdate();
	 }
	 //Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
	 response.sendRedirect("http://localhost:8090/DVOPSAssignment/BookingManagementServlet/dashboard");
	}
	
	
	//method to delete user
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
	//Step 1: Retrieve value from the request
	 String name = request.getParameter("name");
	 //Step 2: Attempt connection with database and execute delete user SQL query
	 try (Connection connection = getConnection(); PreparedStatement statement =
	connection.prepareStatement(DELETE_BOOKINGS_SQL);) {
	 statement.setString(1, name);
	 int i = statement.executeUpdate();
	 }
	 //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
	 response.sendRedirect("http://localhost:8090/DVOPSAssignment/BookingManagementServlet/dashboard");
	}

}
