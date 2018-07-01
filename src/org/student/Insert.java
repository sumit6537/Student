package org.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Insert() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String s2=request.getParameter("Number");
			int rollNo=Integer.parseInt(s2);
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Admin@123");
			Statement stmt1=(Statement) con.createStatement();
			
			Boolean b=stmt1.execute("Select RollNo from student_details where RollNo="+rollNo);
			
			if(b=stmt1.getResultSet().next()) {
			request.setAttribute("val1", b);
				}
				else
				{request.setAttribute("val1", b);
					String name=request.getParameter("Name");
					String s3=request.getParameter("Phy");
					String s4=request.getParameter("Chm");
					String s5=request.getParameter("Maths");
					int phyMarks=Integer.parseInt(s3);
					int chmMarks=Integer.parseInt(s4);
					int mathsMarks=Integer.parseInt(s5);
					PreparedStatement stmt=(PreparedStatement) con.prepareStatement("Insert into student_details (RollNo,Name,PhyMarks,ChmMarks,MathsMarks) values (?,?,?,?,?)");
					stmt.setInt(1, rollNo);
					stmt.setString(2, name);
					stmt.setInt(3, phyMarks);
					stmt.setInt(4, chmMarks);
					stmt.setInt(5, mathsMarks);
					
					Integer i=stmt.executeUpdate();
					request.setAttribute("val", i);
				}
			
			RequestDispatcher rd1 =request.getRequestDispatcher("Add.jsp");
			rd1.forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
