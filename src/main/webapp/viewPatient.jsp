<%@page import="java.util.Iterator"%>
<%@page import="training.entity.Patient"%>
<%@page import="java.util.Set"%>
<%@page import="training.entity.Doctor"%>
<%@page import="training.hib.dao.DoctorPatientDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Doctor doctor = (Doctor) session.getAttribute("doctor");
	Set<Patient> patientSet = DoctorPatientDAO.getPatientListByDoctor(doctor);
	/* pageContext.setAttribute("patientSet",patientSet); */
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient List</title>
</head>
<body>
	<table border="1">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
		</thead>

		<%
			Iterator<Patient> itr = patientSet.iterator();
			while (itr.hasNext()) {

				Patient p = itr.next();
				out.println("<tr>");
				out.println("<td>" + p.getPatientId() + "</td>");
				out.println("<td>" + p.getPatientName() + "</td>");
				out.println("<td>" + p.getPatientAddress() + "</td>");

				out.println("<tr>");
			}
			
		%>

		

	</table>
</body>
</html>