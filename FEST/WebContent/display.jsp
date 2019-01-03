<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FEST|Display</title>
</head>
<BODY>
<style>

body{
background-color:black;
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

OL{
text-align:center;
font-size: 25px;
color:white;
}

OL a{
text-decoration:none;
color:#C0392B;
font-size:30px;
}

i{
color:#C0392B;
}
</style>
<ul>
		<li align="center"><a href="index.html">UNH FEST</a></li>
</ul>
<OL>
   <b>The operation performed is:</b> <i><%=request.getAttribute("operation")%></i><br><br>
   <b>Your id:</b><i><%= request.getParameter("sid") %></i><br><br>
    <b>Event Name you have registered for:</b><i><%= request.getParameter("event") %></i><br><br><br>
    <b></b><A HREF="events.jsp " >Go to Events Page</a> </b>
</OL>         
</BODY>
</html>
