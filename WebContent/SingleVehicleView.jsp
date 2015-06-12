<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle View</title>
<link rel="stylesheet" type = "text/css" href="Vehicles.css">
</head>
<body>
<div class="logo">
<a href="Index.jsp"> <img src="logo.png"> </a>
</div>
<div class="nav">
<a href="VehiclesMenu.jsp">Vehicles</a>
<a href="BookNow.jsp">Book</a>
<a href="AccountsMenu.jsp">Account</a>
</div>
<table class="vehicles">

<%

List<VehicleBean> Vehicle = (List<VehicleBean>)request.getAttribute("Results");
for (VehicleBean i : Item) {
	out.println("<tr>"
	+ "<td rowspan='5' id='IndividualPicture'><img src='" + i.getPicture() + "'></td>"
	+ "<td id='name'>Category: " + i.getCategory() + "- " + i.getMake() + " " + i.getModel() + " " + i.getEngineSize() + "</td>"	
	+ "</tr>"
	+ "<tr>"
	+ "<td id='price'>Price Per Day: £" + i.getPrice() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='price'>Fuel Type: " + i.getFuelType() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='price'>Number Of Doors: " + i.getNoOfDoors() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='price'>Max Weight: " + i.getMaxWeight() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='buying'><form action='mainServlet' method='post'>Enter Date From:<br><br>£"
	+ "<input id='submit' type='date' name='startDate'><br><br>"
	+ "<input type='date' name='endDate'><br><br>"
	+ "<input type='hidden' name='VehicleID' value='" + i.getVehicleID() + "'>"
	+ "<input id='submit' type='submit' value='Book Now' name='go'></form>"
	+ "</td>"
	
	);
}

%>
</table>
<br><br>
</div>

</body>
</html>