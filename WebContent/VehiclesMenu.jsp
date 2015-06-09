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
<a href="#">Vehicles</a>
<a href="#">Book</a>
<a href="#">Account</a>
</div>

<nav class="menu">

<ul class="parent-menu">

<li><form action="AllVehicles" method="post"><input type="submit" name="go" value="View All Vehicles" id="viewVehicles"></form></li><br><br>
<li><a href="#">View All Available Vehicles</a>

	<ul>
	<li><form action="AvailableVehicles" method="post">
	I Want A Vehicle From: <br><input type="date" name="startDate"><br><br>
	Untill:<br><input type="date" name="endDate"><br><br>
	<input type="submit" name="go" value="Get Vehicles"></form></li>
	</ul>

</div>

</body>
</html>

