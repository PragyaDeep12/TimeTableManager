<%@page import="com.pragya.timetable.model.Period"%>
<%@page import="com.pragya.timetable.model.Semester"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%ArrayList<Period> tutorialList=new ArrayList(); %>
<script type="text/javascript">
function addToList( semid,perid,btn)
{ var labelid=document.getElementById("list"+semid);
	labelid.value=labelid.value+" "+perid;

	alert(labelid.value);
	var x=document.getElementById(btn.id);
	x.disabled=true;
	x.style.backgroundColor="red";
	x.textContent="Tutorial";
	//$("#btn"+j).attr("disabled",true);
	}
</script>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
<form action="settutorials.action">

<%ArrayList<Semester> sems=(ArrayList<Semester>)session.getAttribute("semList");
int j=0;
for(Semester sem:sems){%>

<div style="color:white;"><h3><%=sem.getId() %></h3></div>
<input type="text" id="list<%=sem.getId() %>" hidden="true" value="" name="tutorials" >
<%int i=1;%>

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
  <tbody>
<%for(Period per:sem.getTimeTable()){
if(i%4==1){%>
<tr>
<td style="color: white;font-size: 1rem; width: 20px">
<%=per.getDay() %>
<%=i %>
</td>
<%} %>
<td style="width:100px !important">
<button class="btn btn-secondary btn-lg btn-block" id="btn<%=j %>" type="button" onclick="addToList('<%=sem.getId() %>','<%=sem.getTimeTable().indexOf(per)%>',this)"><strong>
null
<%=i %>
<%j++; %>
</strong>
</button>

</td>

<%if(i%4==0){ %>
</tr>
<%} %>
<%i++;%>
<%} %>
</tbody>
</table>


<% }%>
<input type="submit" >
</form>
</body>
</html>