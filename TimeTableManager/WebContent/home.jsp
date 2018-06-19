<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
<div >
<br/>

 
 <div class="jumbotron" style="background-image: url('Images/rotuine1.1.jpg'); background-size: cover;">



  <h1 class="display-3" style="box-shadow: 10px 10px 10px gray;">Routine Generator</h1>
  
  <p class="lead"><strong>Home Page</p>
  <hr class="my-4">
  <p>Welcome to our home page. This website attempts to make routine generation an easy activity for any institution.</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" role="button" href="adminlogin.jsp">Getting Started</a>
  </p>
</div>

<table cellpadding="20px">
	<tr >
		<td width=23% >
		<div class="card text-white bg-primary mb-3 " style="max-width: 20rem;height: 17rem; box-shadow: 10px 10px 10px black;">
		  <div class="card-header">Admin Section</div>
		  <div class="card-body">
		    <h4 class="card-title">Functionalities</h4>
		    <ul class="card-text">
		    <li>Add New Teachers</li>
		    <li>Add new Subject</li>
		    <li>Generate New Routines</li>
		    </ul>
		  </div>
		  </div>
		</td>
		<td  width=23%>
		<div class="card text-white bg-success mb-3 " style="max-width: 20rem;height: 17rem;box-shadow: 10px 10px 10px black; ">
		  <div class="card-header">Teachers</div>
		  <div class="card-body">
		    <h4 class="card-title">Functionalities</h4>
		    <ul class="card-text">
		    <li>Check Timetable</li>
		    <li>Register </li>
		    <li>View Your Profile</li>
		    
		    <li>Edit/Update Details</li>
		    </ul>
		     </div>
		</div>
		
		
		</td>
		<td width=23%>
		
		<div class="card text-white bg-primary mb-3 " style="max-width: 20rem;height: 17rem;box-shadow: 10px 10px 10px black ;">
		  <div class="card-header">Students</div>
		  <div class="card-body">
		    <h4 class="card-title">Functionalities</h4>
		    <ul class="card-text">
		    <li>View Your Timetable</li>
		    <li>View Details of Periods</li>
		    </ul>
		  </div>
		  </div>
		</td>
		<td width=23%>
		<div class="card text-white bg-success mb-3" style="max-width: 20rem;height: 17rem;box-shadow: 10px 10px 10px black; ">
		  <div class="card-header">Routine Generation</div>
		  <div class="card-body">
		    <h4 class="card-title">Process</h4>
		    <p class="card-text">It follows a process of continuous trial and error method to set the routine of each and every semester checking the off days and free periods of the teachers, ensuring each subject gets the necessary number of classes as far as possible.</p>
		  </div>
		</div>
		
		</td>
	</tr>

</table>
</div>
</body>
</html>