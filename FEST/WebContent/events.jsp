<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FEST|Events</title>
</head>
<body>
<style>
body{
background-color:black;
}

h1{
color:white;
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

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  background-color: #2E4053;
  color: white;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #C0392B;
}

form{
color:white;
}

h3{
color:white;
}

</style>

<%String sidvalue="";
   String eventvalue="";
   
   if(request.getAttribute("sid")!=null)
	   sidvalue=(String)request.getAttribute("sid");
    if(request.getAttribute("event")!=null)
	   eventvalue=(String)request.getAttribute("event");%>

<div>
  	<ul>
		<li align="center"><a href="index.html">UNH FEST</a></li>
	</ul>
</div>

<h3 align="center">Scroll down to see the events!</h3>

  <form method="Post" action="FestController">
  Enter Student id:<br>
     <input type="text" name="sid" value=<%=sidvalue%>><br><br>
    Enter the Event Name you want to register:<br>
    <input type="text" name="event" value=<%=eventvalue%>><br>
    <br><br>
    <input type="submit" name="action" value="insert">
    <input type="submit" name="action" value="find">
    <input type="submit" name="action" value="update">
    <input type="submit" name="action" value="delete">
    
  </form>


<h1>UNDERGRADUATE ADMISSION EVENT</h1>
<img src="images/undergraduate-admissions.jpg" alt="Undergraduate Admission Event Image" width="500" height="333">
<br><br>

<h1>GRADUATE ADMISSION EVENT</h1>
<img src="images/grad-events.jpg" alt="Graduate Admission Event Image" width="500" height="333">
<br><br>

<h1>UNDERGRADUATE STUDENT ORIENTATION</h1>
<img src="images/under stud or.jpg" alt="Undergraduate Student Orientation Image" width="500" height="333">
<br><br>

<h1>GRADUATE STUDENT ORIENTATION</h1>
<img src="images/grad stud or.jpg" alt="Graduate Student Orientation Image" width="500" height="333">
<br><br>

<h1>WINTER COMMENCEMENT</h1>
<img src="images/winter commencement.jpg" alt="Winter Commencement Image" width="500" height="333">
<br><br>

<h1>SUMMER COMMENCEMENT</h1>
<img src="images/summer commencement.jpg" alt="Summer Commencement Image" width="500" height="333">
<br><br>

</body>
</html>