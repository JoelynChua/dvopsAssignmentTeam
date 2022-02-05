

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cruds.model.*;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

	
	
	
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	
	private static final String UPDATE_USER = "update users set username = ?, email = ? where ?;";
	private static final String GET_USER = "SELECT * FROM users WHERE ?;";
	
	
	
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
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		

	
		
		//System.out.println(request.getPathTranslated());
		
		String action = request.getServletPath();
		   try {
			   switch(action) {
			   case "/user":
				   showUser(request,response);
				   break;
			   case "/user/update":
				   updateUser(request,response);
				   break;
			   case "/user/reviews":
				   testFunction(request,response);
				   break;
			   case "/user/listings":
				   
				   break;
			   case "/user/bookings":
				   
				   break;
			   case "/user/logout":
				   doLogout(request,response);
				   break;
			   }
		   } catch(SQLException ex) {
			   throw new ServletException(ex);
		   }
		//request.getRequestDispatcher("/account.jsp").forward(request, response);
		response.getWriter().append("Served at: this  ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void showUser(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
		
		HttpSession session = request.getSession();
		Integer user_id = (Integer) session.getAttribute("user_id");
		
		user currentUser = new user(0, "fail", "fail", "fail");
		
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(GET_USER);) {
				
				statement.setInt(1, user_id);
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					String username = rs.getString("username");
					String email = rs.getString("email");
					
					currentUser = new user(0,username,email,"");
					
				}
				
			
				
		} catch (SQLException e) {
			
			System.out.println("error line 129");
			System.out.println(e.getMessage());
		}
		System.out.println(currentUser);
		
		request.setAttribute("currentUser", currentUser);
		request.getRequestDispatcher("/account.jsp").forward(request, response);
		
		
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		System.out.println("function called updateUser");
		//String get_userId = (String) session.getAttribute("user_id");
		Integer user_id = (Integer) session.getAttribute("user_id");
		System.out.println(user_id);
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(UPDATE_USER);) {
					
				statement.setString(1, username);
				statement.setString(2, email);
				statement.setInt(3, user_id);
				
				statement.executeUpdate();
				
		}
		response.sendRedirect("http://localhost:8080/DVOPSAssignment/user");
	
		
	}
	
	
	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().removeAttribute("user_id");
		
		System.out.println("doLogout");
		response.sendRedirect("http://localhost:8080/DVOPSAssignment/login");
		
	}
	
	private void testFunction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<h1>" +"Successful!" +"<h1>");
		writer.close();	
			
		 
	}
	
	
	


}
