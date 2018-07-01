<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="org.student.StudentDetails" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Find.css"> 
</head>
<body>

<%
	List listStudentDetails=(ArrayList)request.getAttribute("results");
		if(listStudentDetails.size()==0)
		{
%>
		<p>Record Not Found</p>
<%
		}
		else
		{
%>
<table>
	<tr>
		<th>Rollno</th>
		<th>Name</th>
		<th>PhyMarks</th>
		<th>ChmMarks</th>
		<th>MathsMarks</th>
	</tr>
<%
			for( int i=0;i<listStudentDetails.size();i++)
			{
			StudentDetails studentDetails=new StudentDetails();
			studentDetails=(StudentDetails)listStudentDetails.get(i);
%>
	<tr>
		<td><%= studentDetails.getRollNo()%></td>
		<td><%= studentDetails.getName()%></td>
		<td><%= studentDetails.getPhyMarks() %></td>
		<td><%= studentDetails.getChmMarks() %></td>
		<td><%= studentDetails.getMathsMarks() %></td>
	</tr>
<% 
			}
		}
%>
</table>
</body>
</html>