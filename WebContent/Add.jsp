<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Add.css">
</head>
<body>
<form action="Add.do" name="add_form">
	<table>
	<tr><td>Name:</td><td><input type="text" name="Name" required></td></tr>
	<tr><td>RollNo:</td><td><input type="text" name="Number" required></td></tr>
	<tr><td>PhyMarks</td><td><input type="number" name="Chm" required></td></tr>
	<tr><td>ChmMarks</td><td><input type="number" name="Phy" required></td></tr>
	<tr><td>MathsMarks</td><td><input type="number" name="Maths" required></td></tr>
	</table>
	<div><input type="submit" value="Add Student" name="Add">
	<input type="submit" value="back" class="form1"></div>
</form>

<%
	{
		if(request.getAttribute("val1")!=null)
		{
			Boolean b=(Boolean) request.getAttribute("val1");
			if(b)
			{
%>
		<p>Duplicate RollNo.. Please enter again</p>
<%
			}
			else
			{
				Integer i =(Integer) request.getAttribute("val");		
				if(i!=0)
				{
%>
		<p>Row has been inserted</p>
<%
				}
			}
		}
	}
%>
</body>
</html>