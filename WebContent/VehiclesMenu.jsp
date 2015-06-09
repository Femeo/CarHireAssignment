<!DOCTYPE html>
<html>
<head>
<title>Vehicles Menu</title>
<link rel="stylesheet" type = "text/css" href="Index.css">
<link rel="stylesheet" type = "text/css" href="DropDown.css">
</head>
<body>

<div class="logo">
<a href="Index.jsp">
<img src="logo.png">
</a>
</div>

<div class="nav">
<a href="VehiclesMenu.jsp">Vehicles</a>
<a href="BookNow.jsp">Book</a>
<a href="#">Account</a>
</div>

<nav id="menu">

<ul class="parent-menu">

<li><form action="AllVehicles" method="post"><input type="submit" name="go" value="View All Vehicles" id="viewVehicles"></form></li>
<li><form><input type="submit" value="View All Available Vehicles" id="viewVehicles"></form>

	<ul>
	<li><form action="AvailableVehicles" method="post">
	I Want A Vehicle From: <br><input type="date" name="startDate"><br><br>
	Untill:<br><input type="date" name="endDate"><br><br>
	<input type="submit" name="go" value="Get Vehicles"></form></li>
	</ul>
</li>
</ul>
</nav>
</body>
</html>

