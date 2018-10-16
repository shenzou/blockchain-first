<%@ page import="java.util.*,com.shenzou.web.jdbc.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Web Student Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

 
<body>
<div id="wrapper">
	<div id="header">
	<h2>ESILV Engineer School</h2>
	</div>
</div>
<div id="container">
<div id="content">
<table>
	<tr>
		<th>First Name </th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>
<c:forEach var="tempStudent" items="${STUDENT_LIST }">
	<tr>
		<td> ${tempStudent.getFirst_name()}</td>
		<td> ${tempStudent.getLast_name()}</td>
		<td> ${tempStudent.getEmail()}</td>
</c:forEach>

</table>
</div>
</div>
</body>



</html>