<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Add.css"> 
<script>
function operation()
{
	s=document.getElementById("selection").value;
	if(s=="between")
		{
		document.getElementById("Phy_box2").style.visibility="visible";
		}
	else
	{
		document.getElementById("Phy_box2").style.visibility="hidden";
	}
}
function operation1()
{
	s=document.getElementById("selection1").value;
	if(s=="between")
		{
		document.getElementById("Chm_box2").style.visibility="visible";
		}
	else
	{
	document.getElementById("Chm_box2").style.visibility="hidden";
	}
}
function operation2()
{
	s=document.getElementById("selection2").value;
	if(s=="between")
		{
		document.getElementById("Mat_box2").style.visibility="visible";
		}
	else
		{
		document.getElementById("Mat_box2").style.visibility="hidden";
		}
}
</script>
</head>
<body>
<form action="Find.do" name="search_form" method="get" accept-charset="utf-8" >
	<table>
	<tr><td>Name:</td><td><input type="text" name="Name" ></td></tr>
	<tr><td>RollNo:</td><td><input type="text" name="rollNo"></td></tr>
	<tr><td>PhyMarks</td><td><select name="Phy" oninput="operation();" id="selection">
			<option ></option>
			<option value=">">></option> 
  			<option value="<"><</option>
  			<option value="=">=</option>
  			<option value="between">between</option>
  			<option value=">=">>=</option>
  			<option value="<="><=</option>
  			</select>
	</td>
	<td>
		<input type="text" name="phy_Number" >
		<input type="text" name="phy_Number1" id="Phy_box2" style="visibility:hidden;">
	</td>
	</tr>
	
	<tr><td>ChmMarks</td><td><select name="Chm" oninput="operation1();" id="selection1">
			<option ></option>
			<option value=">">></option> 
  			<option value="<"><</option>
  			<option value="=">=</option>
  			<option value="between">between</option>
  			<option value=">=">>=</option>
  			<option value="<="><=</option>
  			</select>
	</td>
	<td>
		<input type="text" name="chm_Number" >
		<input type="text" name="chm_Number1" id="Chm_box2" style="visibility:hidden;">
	</td>
	</tr>
	
	<tr><td>MathsMarks</td><td><select name="Maths" oninput="operation2();" id="selection2">
			<option ></option>
			<option value=">">></option> 
  			<option value="<"><</option>
  			<option value="=">=</option>
  			<option value="between">between</option>
  			<option value=">=">>=</option>
  			<option value="<="><=</option>
  			</select>
	</td>
	<td>
		<input type="text" name="maths_Number" >
		<input type="text" name="maths_Number1" id="Mat_box2" style="visibility:hidden;">
	</td>
	</tr>
	
	</table>
	<div><input type="submit" value="Search" name="Search"></div>
</form>
<% 	
	String message=(String)request.getAttribute("Error");
	if(message!=null){
%>
	<p><%=message %></p>
<%
	}
%>
</body>
</html>