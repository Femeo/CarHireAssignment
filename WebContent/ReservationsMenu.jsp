<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservations</title>
<link rel="stylesheet" type = "text/css" href="ReservationsMenu.css">
</head>
<body>

<div class="logo">
<a href="StaffIndex.jsp"> <img src="logo.png"> </a>
</div>
<div class="nav">
<a href="AddVehicle.jsp">Add Vehicle</a>
<a href="RemoveVehicle.jsp">Remove Vehicle</a>
<a href="ReservationsMenu.jsp">Reservations</a>
<a href="AllVehicles.jsp">All Vehicles</a>
</div>
<div id="main">
<ul class="menu">
<li><form action="AllReservations" method="post"><input type="submit" name="go" value="View All Reservations" id="viewReservations"></form></li>
<br><br><li><form action="AllUpcomingReservations" method="post"><input type="submit" name="go" value="View all Upcoming Reservations" id="viewUpcomingReservations"></form></li>
<br><br><li><form action="AllPreviousReservations" method="post"><input type="submit" name="go" value="View all Previous Reservations" id="viewPreviousReservations"></form></li>
</ul>
</div>
</body>
</html>