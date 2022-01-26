

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String pass;
    String comparePass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		
		
		String input_username = request.getParameter("loginInput_username");
		String input_password = request.getParameter("loginInput_password");
		
		//First we have to do query to get given username.
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// This is database url, userdetails is the database NOT TABLE
			Connection con = DriverManager.getConnection(
					
			 "jdbc:mysql://localhost:3306/userdetails", "root", "password");
			// SELECT FROM users, users is the table that exists in the userdetails database.
			// Can change accordingly thanks
			PreparedStatement ps = con.prepareStatement("SELECT *  FROM `users` WHERE `username` = ? ;");
			ps.setString(1, input_username);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
				String password = rs.getString("password");
				String name = rs.getString("username");
			
			
			//String password = rs.getString("password");
			//System.out.println(password);

			HttpSession session = request.getSession();
			if(input_username.equals(name) && input_password.equals(password)){
				

				session.setAttribute("user_id", rs.getString("user_id"));	
				String get_userId = (String) session.getAttribute("user_id");	
			//	System.out.println(get_userId);
				
				response.sendRedirect("http://localhost:8080/DVOPSAssignment/user");
				
			}
			else {
				
				System.out.println("error");
			}
		}
		
		catch(Exception exception) {
			System.out.println(exception.getMessage());
			
			out.close();
		}

		// TODO Auto-generated method stub
	//	doGet(request, response);
	}
	
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException { 

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String input_username = request.getParameter("loginInput_username");
		String input_password = request.getParameter("loginInput_password");
		
		//First we have to do query to get given username.
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/userdetails", "root", "password");
			
			PreparedStatement ps = con.prepareStatement("SELECT `password` FROM `users` WHERE `username` = ? ;");
			ps.setString(1, input_username);
			
			ResultSet rs = ps.executeQuery();
			
			String password = rs.getString("password");
			//System.out.println(password);
			System.out.println(rs);
		}
		
		catch(Exception exception) {
			System.out.println(exception);
			
			out.close();
		}
		
		
	}
}
