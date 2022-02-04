

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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String action = request.getServletPath();
		
		 request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String a = request.getParameter("username");
		String b = request.getParameter("email");
		String c = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/ecommerce", "root", "password");
			 
			 PreparedStatement ps = con.prepareStatement("INSERT INTO `users`(`username`, `email`, `password`) VALUES (?,?,?)");
			 
			 ps.setString(1, a);
			 ps.setString(2, b);
			 ps.setString(3, c);
			 
			 int i = ps.executeUpdate();
			 
			 if (i > 0 ) {
				 
				 request.getRequestDispatcher("/register_success.html").forward(request, response);
				 
			 }
			 else {
				 System.out.println("Fail");
			 }
		}
		
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		
		doGet(request, response);
	}

}
