<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Vehicle</title>
<link rel="stylesheet" type = "text/css" href="AddVehicle.css">

</head>
<body>

<div class="logo">
<a href="StaffIndex.jsp"> <img src="logo.png"> </a>
</div>

<div class="nav">
<a href="AddVehicle.jsp">Add Vehicle</a>
<a href="RemoveVehicle.jsp">Remove Vehicle</a>
<a href="Reservations.jsp">Reservations</a>
<a href="AllVehicles.jsp">All Vehicles</a>
</div>

<div class="Form">
		<form action="mainServlet" method="post">
		<br>
		Vehicle ID: 	 <input type="text" name="ID"> 
		<br><br>
		<input type="submit" value="Remove Vehicle" name="go" >
		</form>
</div>
	

</body>
</html>