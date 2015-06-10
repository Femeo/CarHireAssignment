<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Available Vehicles</title>
<link rel="stylesheet" type = "text/css" href="Vehicles.css">
</head>
<body>
<div class="logo">
<a href="Index.jsp"> <img src="logo.png"> </a>
</div>
<div class="nav">
<a href="VehiclesMenu.jsp">Vehicles</a>
<a href="#">Book</a>
<a href="#">Account</a>
<a href="#">Staff</a>
</div>
<nav id="categories">
<ul>
	<li><form action="mainServlet" method="post"><input type="submit" name="go" value="Category A"></form></li>
	<li><form action="mainServlet" method="post"><input type="submit" name="go" value="Category B"></form></li>
	<li><form action="mainServlet" method="post"><input type="submit" name="go" value="Category C"></form></li>
	<li><form action="mainServlet" method="post"><input type="submit" name="go" value="Vans"></form></li>
	<li><form action="mainServlet" method="post"><input type="submit" name="go" value="All"></form></li>
</ul>
</nav>
<nav id="main">
<table class="vehicles">
<%

List<VehicleBean> allVehicles = (List<VehicleBean>)request.getAttribute("Results");
for (VehicleBean i : allVehicles) {
	out.println("<tr>"
	+ "<td id='picture'><img src='" + i.getPicture() + "'></td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='name'>"  + i.getMake() + i.getModel + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='price'> Price Per Day: £"  + i.getPricePerDay() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td><form action='singleServlet' method='post'><input type='hidden' name='vehicleID' value='" + i.getVehicleID() + "'><input type='submit' id='hire' value='Hire Vehicle'></form></td>"
	+ "</tr>");
	
}
	
%>
</table>
</nav>

</body>
</html>