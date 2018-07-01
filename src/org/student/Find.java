package org.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Find
 */
@WebServlet("/Find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	try{
			boolean b=false;
			long startTime = System.currentTimeMillis();
			StringBuilder query1=new StringBuilder("Select * from student_details where");
			
			String name=request.getParameter("Name");
			if(!(name==null||name.equals(""))) 
				query1=query1.append(" name='" + name + "' "+ "And");
				
			String roll_str=request.getParameter("rollNo");
			if(!(roll_str==null||roll_str.equals(""))) {
				int roll=Integer.parseInt(roll_str);
					query1=query1.append(" RollNo=" + roll +" And");
			}
			
			
			String phy=request.getParameter("Phy");
			if(!(phy==null||phy.equals(""))) 
			{
				String phyNumber=request.getParameter("phy_Number");
				if(phyNumber.equals(""))
				{
					b=true;
				}
				else{
					int phy_Number=Integer.parseInt(phyNumber);
					String phyNumber1=request.getParameter("phy_Number1");
					if(phy.equals("between"))
					{
						int phy_Number1=Integer.parseInt(phyNumber1);
						query1=query1.append(" PhyMarks "+ phy+ " " + phy_Number+ " "+ " and " + phy_Number1+ " And");
					}
					else
						query1 = query1.append(" PhyMarks " + phy + phy_Number + " And");
				}
			}
		
			
			String chm=request.getParameter("Chm");
			if(!(chm==null||chm.equals(""))) 
			{
				String chmNumber=request.getParameter("chm_Number");
				if(chmNumber.equals(""))
				{
					b=true;
				}
				else
				{
					int chm_Number=Integer.parseInt(chmNumber);
					String chmNumber1=request.getParameter("chm_Number1");
					if(chm.equals("between"))
					{
						int chm_Number1=Integer.parseInt(chmNumber1);
						query1=query1.append(" ChmMarks "+chm+ " " + chm_Number+ " "+ " and " + chm_Number1+ " And");
					}
					else
						query1=query1.append(" ChmMarks " + chm + chm_Number+ " And");
				}
			}
			
			String mat=request.getParameter("Maths");
			if(!(mat==null||mat.equals(""))) 
			{
				String mathsNumber=request.getParameter("maths_Number");
				if(mathsNumber.equals(""))
				{
					b=true;
				}
				else
				{
					int maths_Number=Integer.parseInt(mathsNumber);
					String mathsNumber1=request.getParameter("maths_Number1");
					if(mat.equals("between"))
					{
						int maths_Number1=Integer.parseInt(mathsNumber1);
						query1=query1.append(" MathsMarks "+ mat + " "+ maths_Number+ " "+ " and " + maths_Number1+ " And");
					}	
				else
						query1=query1.append(" MathsMarks " + mat + maths_Number+ " And");
				}
			}
				if(b==false)
				{
					
					String query=query1.toString();
					if(query.endsWith("And"))	
						query=query.substring(0, (query.length()-4));
					else if(query.endsWith("where"))
						query=query.substring(0, (query.length()-5));
					
					
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Admin@123");
					Statement stmt2=(Statement) con1.createStatement();
					ResultSet resultSet=stmt2.executeQuery(query);
				
					List<StudentDetails> listStudentDetails=new ArrayList<StudentDetails>();
					while(resultSet.next())
					{
						StudentDetails studentDetails =new StudentDetails();
						studentDetails.setName(resultSet.getString(2));
						studentDetails.setRollNo(resultSet.getInt(1));
						studentDetails.setChmMarks(resultSet.getInt(4));
						studentDetails.setPhyMarks(resultSet.getInt(3));
						studentDetails.setMathsMarks(resultSet.getInt(5));
						listStudentDetails.add(studentDetails);
					}
					
					request.setAttribute("results", listStudentDetails);
					RequestDispatcher requestDispatcher =request.getRequestDispatcher("View.jsp");
					requestDispatcher.forward(request, response);
				}
				else
				{
					String message="Please insert proper values";
					request.setAttribute("Error", message);
					RequestDispatcher requestDispatcher1 =request.getRequestDispatcher("Search.jsp");
					requestDispatcher1.forward(request, response);
				}
				
				
		}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();}
		catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
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
