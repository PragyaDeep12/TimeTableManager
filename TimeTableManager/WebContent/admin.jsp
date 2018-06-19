<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
<table width=50% bordercolor=white><tr><td width=50% bordercolor=white>


<label class="form-control">Add New Teacher</label>
<a href="teacher_registration.jsp" class="btn btn-success">New Teacher>></a>
<br/>
<br/>
<label class="form-control">Add New Subject</label>
<a href="new_subject.jsp" class="btn btn-success">NewSubject>></a>
<br/>
<br/>
<label class="form-control"><strong>Generate Routine</strong></label>
<a class="btn btn-dark" href="generateNewRoutine.action">New Routine>></a>

<br>
<br/>

</td>
<td style="padding-top: 0px" width=50%>
		<label class="form-control"><strong>View Teacher's Routine</strong></label>
		<a class="btn btn-dark" href="selectTeacher.action">Teacher's Page>></a>
		<br/>
		<br/>
		<label class="form-control"><strong>View Teacher Details</strong></label>
		<a class="btn btn-success" href="viewTeacher.action">View Teachers</a>
    	 <label class="form-control"><strong>View Sem Routine</strong></label>

		 <table>
		 
		<tr>
		<td>
			<div>
			<table>
			<tr>
			<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=1">1st Sem Routine>></a>
				</td>
				</tr>
				<tr>
				<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=3">3rd Sem Routine>></a>
				</td>
				</tr>
				<tr>
				<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=5">5th Sem Routine>></a>
				</td>
				</tr>
				<tr>
				<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=7">7th Sem Routine>></a>
				</td>
				</tr>
				</table>
			</div>
		
		</td>
		<td>
			<div>
			<table>
			<tr>
			<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=2">2nd Sem Routine>></a>
				</td>
				</tr>
				<tr>
				<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=4">4th Sem Routine1>></a>
				</td>
				</tr>
				<tr>
				
				<td width=25%>
					<a class="btn btn-success" href="viewSemRoutine?sem=6">6th Sem Routine>></a>
				</td>
				</tr>
				<tr>
				<td width=25%>
				
					<a class="btn btn-success" href="viewSemRoutine?sem=8">8th Sem Routine>></a>
				</td>
				</tr>
				</table>
			</div>
		
		</td>
		</tr>
		
		</table>
		
</td></tr></table>
</body>
</html>