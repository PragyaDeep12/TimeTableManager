<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
<div style="padding-left: 500px; padding-top: 50px">
<div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
  <div class="card-header"><h4 align="center">Login</h4></div>
  <div class="card-body">
  <form action="teacherlogin.action">
    
    <div class="form-control has-success">
    <input type="text" class="form-control" placeholder="Serial Number" name="id" >
    
    <br/>
    
    <input type="password" class="form-control" placeholder="Password" name="password">
    
   </div>
    <br/>
    <table width=100% >
    	<tr>
    	<td>
    	<input type="submit" class=" btn btn-success">
    	</td>
    	<td>
    	 <a href="teacher_registration.jsp" class="btn btn-success">Register</a>
    	</td>
    	</tr>
    </table>
    
   
    </form>
    <br/>
    <p class="card-text"></p>
    </div>
  </div>
  </div>
</div>
</body>
</html>