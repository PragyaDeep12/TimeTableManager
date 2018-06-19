<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Off Days</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >

<table>
<tr><td>

<div class="card border-primary mb-3" style="max-width: 20rem;">
  <div class="card-header">Select Off Days</div>
  <div class="card-body">
  <s:form action="teacherOffDays.action">
  <s:textfield  name="tid"><s:property value="tid"/></s:textfield> 
  <s:checkboxlist list="days" name="offDays" cssStyle="width:50%"></s:checkboxlist>
  <s:submit>change</s:submit>
  </s:form>
  </div>
</div>
</td>
<td>
<div class="card border-primary mb-3" style="max-width: 20rem;">
  <div class="card-header">Your Off Days</div>
  <div class="card-body">
    
    
  </div>
</div>
</td>
</tr>
</table>

</body>
</html>