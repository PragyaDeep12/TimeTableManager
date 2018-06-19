<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subject</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<jsp:include page="Includes/master.jsp"/>
<body style="background-image:url('Images/blackback.jpg'); background-size:cover;" >

<div>
<script type="text/javascript">
function validate()
{
	 
	var islab= document.forms[0].isLab.value;
	
	 if(islab=='yes')
		{
			document.forms[0].ifLab.value=1;
		}
	else 
		document.forms[0].ifLab.value=0;
	
	return true;
	}
</script>
<div style="padding-left: 500px; padding-top: 50px">
<div class="card text-white bg-primary mb-3" style="max-width: 20rem;box-shadow: 10px 20px 30px black;">
  <div class="card-header"><h4>Add Subject</h4></div>
  <div class="card-body">
    <p class="card-text">
    <s:form action="addsubject.action" onsubmit="return validate();">
	<s:textfield name="name" label="Subject Name"></s:textfield>
	<s:textfield name="subCode" label="Subject Code"></s:textfield>
	<s:select name= "year" label="Year" list="{'1','2','3','4'}" style="width:10rem"></s:select>
	<s:select name="sem" label="Semester" list="{'1','2','3','4','5','6','7','8'}" style="width:10rem" ></s:select>
	<s:select name="classes" label="Classes" list="{'1','2','3','4'}" style="width:10rem"></s:select>
	<s:radio list="{'yes','no'}" label="LAB" name="isLab" id="isLab" value="{'1','0'}"></s:radio>
	
	<s:textfield name="ifLab" id="ifLab" hidden="true"></s:textfield>
	<s:submit cssClass="btn btn-success"></s:submit>
	</s:form>
	</p>
</div>
</div>
</div>
</div>
</body>
</html>