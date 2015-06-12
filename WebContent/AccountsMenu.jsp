<!DOCTYPE html>
<html>
<head>
<title>Vehicles Menu</title>
<link rel="stylesheet" type = "text/css" href="Index.css">
</head>
<body>

<button onClick="location.href='FirstPage.jsp'" id="logout">Log Out</button>


<div class="logo">
<a href="Index.jsp">
<img src="logo.png">
</a>
</div>

<div class="nav">
<a href="VehiclesMenu.jsp">Vehicles</a>
<a href="BookNow.jsp">Book</a>
<a href="AccountsMenu.jsp">Account</a>
</div>

<nav id="menu">

<form action="mainServlet" method="post">
<input type="submit" name="go" value="View Your Current Reservations">
<input type="submit" name="go" value="View Your Upcoming Reservations">
<input type="submit" name="go" value="View Your Previous Contracts">
</form>
<br><br>
</nav>
</body>
</html>
