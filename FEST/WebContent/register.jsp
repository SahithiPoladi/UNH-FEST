<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FEST|Register</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #2E4053;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #2E4053;
}

li {
    float: center;
}

li a {
    display: inline-block;
    color: white;
	font-weight:bold;
    text-align: center;
    padding: 40px 30px;
    text-decoration: none;
}

li a:hover {
    background-color: #C0392B  ;
}

</style>
</head>
<body>
<form method="post" action="RegisterController">
  <div class="container">
  	<ul>
		<li align="center"><a href="index.html">UNH FEST</a></li>
	</ul>
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<label for="txt_fname"><b>First Name</b></label>
	<input type="text" placeholder="Enter First Name" name="txt_firstname" required>
	
	<label for="txt_lname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="txt_lastname" required>
	
    <label for="txt_email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="txt_email" required>

    <label for="txt_password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="txt_password" required>

    <button type="submit" name="btn_register" value="Register" class="registerbtn">REGISTER</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
  </div>
</form> 
    
</body>
</html>
