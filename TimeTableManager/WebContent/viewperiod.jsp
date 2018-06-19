<%@page import="com.pragya.timetable.model.Period"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Period</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">

</head>

<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >

<% Period period= (Period)session.getAttribute("period"); %>
<div style="padding-left: 15rem; padding-top: 5rem">
<div class="card text-white bg-secondary mb-3" style="max-width: 30rem;">
  <h3 class="card-header">Period</h3>
  <div class="card-body">
    <h4 class="card-title">Subject:<%=period.getSubject().getName() %></h4>
    <p class="card-text"><h5>Teacher:<%=period.getTeacher().getName()%></h5>
    Sem:<%=period.getSem() %>
    <br>
    Period Number:<%=period.getTime() %>
    <br>
    Day:<%=period.getDay() %>
    <br>
    Lab:<%if(period.getSubject().isIfLab()==0){ %>
    No
    <%}else{ %>
    Yes
    <%} %>
    <br>
    Email-id: <%=period.getTeacher().getEmail()%>
    <br>
    Phone-Number:<%=period.getTeacher().getPhone()%>
    
    </p>
  </div>
  </div>
</div>
</body>
</html>