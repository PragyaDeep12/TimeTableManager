<%@page import="com.pragya.timetable.model.Period"%>
<%@page import="com.pragya.timetable.model.Semester"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
hello
<table class="table table-active">
<thead>
    <tr style="font-size: 1.5rem; color: white;">
    <th scope="col" align="center">Day</th>
      <th scope="col" align="center">First</th>
      <th scope="col" align="center">Second</th>
      <th scope="col" align="center">Third</th>
      <th scope="col" align="center">Fourth</th>
    </tr>
  </thead>
<%
Semester semester= (Semester)session.getAttribute("tRoutine");
String []weekday={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
int i=1;
int day=0;
for(Period per:semester.getTimeTable()){
if(i%4==1){%>
<tr>
<td style="color: white;font-size: 1rem; width: 20px">
<%=weekday[day] %>
<%day++; %>
</td>
<%} %>
<td style="width:100px !important">
<%if(per.getSubject()!=null)
{
	
		%>
		<a class="btn btn-primary btn-lg btn-block" type="button" style="width:100%" href="viewPeriod.action?perid=<%=per.getId() %>">
		<strong>
		
<%=per.getSubject().getName() %>

</strong>
</a>
		
		<%}
else{%>
<button class="btn btn-secondary btn-lg btn-block" type="button"><strong>
null
</strong>
</button>
<% }%>
</td>
<%if(i%4==0){ %>
</tr>
<%} %>
<%i++;%>
<%}%>
</table>
<hr  color="black" >
<br><br>


</body>
</html>