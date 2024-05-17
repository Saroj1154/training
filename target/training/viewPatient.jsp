<%@page import="java.util.Iterator" %>
<%@page import="training.entity.Patient" %>
<%@page import="java.util.Set" %>
<%@page import="training.entity.Doctor" %>
<%@page import="training.hib.dao.DoctorPatientDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%
    Doctor doctor = (Doctor) session.getAttribute("doctorObj");
    Set<Patient> patientSet = DoctorPatientDAO.getPatientListByDoctor(doctor);
	pageContext.setAttribute("patientObjSet", patientSet);
	pageContext.setAttribute("doctorObj", doctor);
	pageContext.setAttribute("Desc", "Demo to jstl");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Patient List</title>
</head>
<body>
<br>
<%--Doctor Name :- <%= doctor.getDoctorName()%>--%>
<br>
Doctor Name :- ${doctorObj.doctorName}
${Desc}

<C:out value="${Desc}" />
<br>
<table border="1">
    <thead>
    <th>Id</th>
    <th>Name</th>
    <th>Address</th>
    <th>Doctor Name</th>
    </thead>

    <C:forEach items="${patientObjSet}" var="p">
        <tr>
            <td>${p.patientId}</td>
            <td>${p.patientName}</td>
            <td>${p.patientAddress}</td>
            <td></td>
        </tr>
    </C:forEach>



    <%--<%
        Iterator<Patient> itr = patientSet.iterator();
        while (itr.hasNext()) {

            Patient p = itr.next();
            out.println("<tr>");
            out.println("<td>" + p.getPatientId() + "</td>");
            out.println("<td>" + p.getPatientName() + "</td>");
            out.println("<td>" + p.getPatientAddress() + "</td>");
            out.println("<td>" + doctor.getDoctorId()+" - "+doctor.getDoctorName() + "</td>");
            out.println("<tr>");
        }

    %>
--%>


</table>
</body>
</html>