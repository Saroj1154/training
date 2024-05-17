<%--
  Created by IntelliJ IDEA.
  User: bhatp
  Date: 5/16/2024
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Registration</title>
</head>
<body>

<form action="registerDoctorAction.jsp" method="post" >
    Doctor Name <input type="text" name="doctorName" >
    <br>
    <br>
    Doctor Email <input type="text" name="doctorEmail" >
    <br>
    <br>
    Doctor Password <input type="text" name="doctorPassword" >
    <br>
    <br>
    Doctor Address <input type="text" name="doctorAddress" >
    <br>
    <br>

    <input type="submit" value="addDoctor"/>

</form>
</body>
</html>
