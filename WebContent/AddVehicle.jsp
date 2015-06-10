<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Vehicle</title>
<link rel="stylesheet" type = "text/css" href="AddVehicle.css">

</head>
<body>
<button onClick="location.href='FirstPage.jsp'" id="logout">Log Out</button>

<div class="logo">
<a href="StaffIndex.jsp"> <img src="logo.png"> </a>
</div>

<div class="nav">
<a href="AddVehicle.jsp">Add Vehicle</a>
<a href="RemoveVehicle.jsp">Remove Vehicle</a>
<a href="ReservationsMenu.jsp">Reservations</a>
<a href="AllVehicles.jsp">All Vehicles</a>
</div>

<div class="Form">
		<form action="mainServlet" method="post">
		Vehicle ID: 	 <input type="text" name="ID"> 
		<br><br>
		Category:        <input type="text" name="category">
		<br><br>
		Make:            <input type="text" name="make">
		<br> <br>
		Model:           <input type="text" name="model">
		<br><br>
		Engine Size:     <input type="text" name="engine">
		<br><br>
		Price (Per Day): £<input type="text" name="price">
		<br><br>
		Fuel Type:       <input type="text" name="fuel">
		<br><br>
		Number of Doors: <input type="text" name="doors">
		<br><br>
		Maximum Weight:  <input type="text" name="max">
		<br><br>
		Picture (URL):   <input type="text" name="picture">
		<br><br>
		<br><br>
		<input type="submit" value="Add Vehicle" name="go" >
		</form>
</div>
	

</body>
</html>