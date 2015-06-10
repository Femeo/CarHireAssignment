<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Log In</title>
<link rel="stylesheet" type = "text/css" href="Login.css">
</head>
<body>

<div class="logo">
<a href="FirstPage.jsp"> <img src="logo.png"> </a>
</div>

<section class="container">
<div class="login">
      <h1>Customer Login</h1>
      <form method="post" action="mainServlet">
        <p><input type="text" name="login" value="" placeholder="Username"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p class="submit"><input type="submit" name="go" value="Login"></p>
      </form>
</div>

<div class="login-help">
      <p>Forgot your password? <a href="ForgottenPassword.jsp">Click here to reset it</a>.</p>
</div>
</section>

</body>
</html>