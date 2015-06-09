<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Now</title>
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
</div>
<br><br><br>
<div class="forms">
<form action="mainServlet" method="post">
Please Enter The Vehicle ID:<br>
<input type="text" name="vehicleID"><br><br>
Enter The Date You Wish To Start The Reservation:<br>
<input type="date" name="startDate"><br><br>
Enter The Reservation End Date:<br>
<input type="date" name="endDate"><br><br>
<input type="submit" name="go" value="Book Vehicle" id="submit">
<br>
<br>
</form>
</div>
</body>
</html>