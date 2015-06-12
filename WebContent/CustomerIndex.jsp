<!DOCTYPE html>
<html>
<head>
<title>Homepage</title>
<link rel="stylesheet" type = "text/css" href="Index.css">
</head>
<body>
<button onClick="location.href='FirstPage.jsp'" id="logout">Log Out</button>
<div class="logo">
<a href="Index.jsp"> <img src="logo.png"> </a>
</div>
<div class="nav">
<a href="VehiclesMenu.jsp">Vehicles</a>
<a href="BookNow.jsp">Book</a>
<a href="AccountsMenu.jsp">Account</a>
</div>
<div class="container">
   <div id="content-slider">
      <div id="slider">  <!-- Slider container -->
         <div id="mask">  <!-- Mask -->

         <ul>
         <li id="first" class="firstanimation">  <!-- ID for tooltip and class for animation -->
         <a href="#"> <img src="http://parkers.bauercdn.com/PageFiles/72620/New_Kia_c'eed_Kia_32761.jpg" alt="Car"/> </a>
         <div class="tooltip"> <h1>Cougar</h1> </div>
         </li>

         <li id="second" class="secondanimation">
         <a href="#"> <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJszPmOkzOhLTyNtIBjfIkJ41GT_zbcdLF76SKAPh3wyz-bp9H" alt="Car"/> </a>
         <div class="tooltip"> <h1>Lions</h1> </div>
         </li>

         <li id="third" class="thirdanimation">
         <a href="#"> <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRsqsU97bqrbVJAqTqxI5nSJsWaKrVmwMzKgc-KpWNQcvPUNdNG" alt="Car"/> </a>
         <div class="tooltip"> <h1>Snowalker</h1> </div>
         </li>

         <li id="fourth" class="fourthanimation">
         <a href="#"> <img src="http://www.intelligentcarleasing.com/blog/wp-content/uploads/2013/11/New-i10-family-car-300x187.jpg" alt="Car"/> </a>
         <div class="tooltip"> <h1>Howling</h1> </div>
         </li>

         <li id="fifth" class="fifthanimation">
         <a href="#"> <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR-xy8ESLxVhmHhAfDAA8PWdNk04t9_dPDq1Y3XPbfeAUxiPyzlWQ" alt="Car"/> </a>
         <div class="tooltip"> <h1>Sunbathing</h1> </div>
         </li>
         </ul>

         </div>  <!-- End Mask -->
         <div class="progress-bar"></div>  <!-- Progress Bar -->
      </div>  <!-- End Slider Container -->
   </div>
</div>
<br><br><br><br>
</body>
</html>