<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FEST|Login</title>
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
.loginbtn {
  background-color: #2E4053;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.loginbtn:hover {
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

<form method="post" action="LoginController">
  <div class="container">
  <ul>
		<li align="center"><a href="index.html">UNH FEST</a></li>
	</ul>
    <h1>Login</h1>
    <p>Enter your credentials.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="txt_email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="txt_password" required>

    <button type="submit" name="btn_login" value="Login"  class="loginbtn">Login</button>
  </div>
  
  <div class="container signin">
    <h3>Not an User? <a href="register.jsp">Sign Up</a>.</h3>
  </div>
</form>

<h3 style="color:green">
                <%
                    if(request.getAttribute("RegiseterSuccessMsg")!=null)
                    {
                        out.println(request.getAttribute("RegiseterSuccessMsg")); //get register success message from RegisterController
                    }
                %>
            </h3>
            
            <h3 style="color:red">
                <%
                    if(request.getAttribute("WrongLoginMsg")!=null)
                    {
                        out.println(request.getAttribute("WrongLoginMsg")); //get login error message from LoginController
                    }
                %>
            </h3>

</body>
</html>
