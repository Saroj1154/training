<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Patient</title>
</head>
<body>

<form action="addPatientAction.jsp" method="post" >
    Patient Name <input type="text" name="patientName" >
    <br>
    Patient Email <input type="text" name="patientEmail" >
    <br>
    Patient Password <input type="text" name="password" >
    <br>

    Patient Address <input type="text" name="patientAddress" >
    <br>

    <input type="submit" value="Login"/>

</form>

</body>
</html>
