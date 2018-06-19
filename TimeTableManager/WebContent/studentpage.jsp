<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/CustomFlatly.css">
<title>Student's Page</title>
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
<br/>
 <label class="form-control"><strong>View Sem Routine</strong></label>

 <table>
<tr>
<td colspan="2">

</td>
</tr>
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
			<a class="btn btn-success" href="viewSemRoutine?sem=4">4th Sem Routine>></a>
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


</body>
</html>