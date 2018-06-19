<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teachers</title>
<link rel="stylesheet" href="CSS/CustomFlatly.css">
</head>
<body>
<div>

<table class="table table-hover" style="background-color: white;">
  <thead >
  <tr>
  
  <th scope="col">Serial No</th>
  <th scope="col">Name</th>
  <th scope="col">Email</th>
  <th scope="col">Phone</th></tr>
  </thead>
  <s:iterator value="tlist">
  <tbody>
  <tr>
  <td><s:property value="id"/>
  </td>
  <td><s:property value="name"/>
  </td>
  <td><s:property value="email"/>
  </td>
  <td><s:property value="phone"/>
  </td>
  </tr>
  </tbody>
  </s:iterator>
  </table>

  </div>
</body>
</html>