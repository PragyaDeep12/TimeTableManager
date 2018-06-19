<%@page import="com.pragya.timetable.model.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TimeTable</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >

<%ArrayList<Teacher> tList=(ArrayList<Teacher>)session.getAttribute("tList");
%>
<table class="table table-active">
<%
for(Teacher t:tList)
{
%>
<tr>
<td style="color: white;font-size: 1rem; width: 20px"><%=t.getId() %></td>
<td style="color: white;font-size: 1rem; width: 40px"><%=t.getName() %></td>
<td><a class="btn btn-success" href="viewTeacherRoutine.action?tid=<%=t.getId()%>">View Routine >></a></td>
<td></td>
</tr>

<%} %>
</table>
</body>
</html>