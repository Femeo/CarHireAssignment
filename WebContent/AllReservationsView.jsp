<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Reservations</title>
</head>
<body>

<div class="logo">
<a href="Index.jsp"> <img src="logo.png"> </a>
</div>
<div class="nav">
<a href="VehiclesMenu.jsp">Vehicles</a>
<a href="BookNow.jsp">Book</a>
<a href="#">Account</a>
</div>

<nav id="main">
<table class="vehicles">
<%

List<ContractBean> allContracts = (List<ContractBean>)request.getAttribute("Results");
for (ContractBean i : allContracts) {
	out.println("<tr>"
	+ "<td id='ContractID>" + i.getContractID() + "</td>"
	+ "</tr>"
	+ "<td id='CustomerID'>" + i.getCustomerID() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='VehicleID'>"  + i.getVehicleID() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='HiredFrom'>"  + i.getHiredFrom() + "</td>"
	+ "</tr>"
	+ "<tr>"
	+ "<td id='HiredUntill'>" + i.getHiredUntill() + "</td>"
	+ "</tr>");
	
}
	
%>
</table>
</nav>

</body>
</html>