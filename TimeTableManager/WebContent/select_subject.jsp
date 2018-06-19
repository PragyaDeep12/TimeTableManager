<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Subject</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >
<div class="card text-white bg-secondary mb-3" style="max-width: 20rem;">
  <div class="card-header">Select Off Days</div>
  <div class="card-body">
  <s:form action="setsubject.action">
  <s:textfield  name="tid"></s:textfield> 
  <s:checkboxlist list="slist" name="selectedSubject" cssStyle="width:50%">

  </s:checkboxlist>
  <s:submit></s:submit>
  </s:form>
  </div>
</div>

</body>
</html>