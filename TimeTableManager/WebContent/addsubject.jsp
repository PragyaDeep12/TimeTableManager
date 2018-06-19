<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Subject</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >


			<div style="padding-left: 500px; padding-top: 50px">
			<div class="card text-white bg-primary mb-3" style="max-width: 20rem;">
			  <div class="card-header"><h4 align="center">Register</h4></div>
			  <div class="card-body">
			<s:form action="addsubject.action">
			<s:textfield name="name" label="Name" cssClass="form-control"></s:textfield>
			<s:textfield name="sem" label="Sem"  cssClass="form-control" type="number"></s:textfield>
			<s:textfield name="subCode" label="Subject Code" cssClass="form-control"></s:textfield>
			<s:textfield name="year" label="Year" cssClass="form-control"></s:textfield>
			<s:textfield name="classes" label="Number of Classes" cssClass="form-control"></s:textfield>
			<s:radio list="{'Lab'}" name="ifLab" label="Lab"></s:radio>
			<s:submit cssClass="btn btn-success" ></s:submit>
			</s:form>
			</div>
			</div>
			</div>
		
</body>
</html>