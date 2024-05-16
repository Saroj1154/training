<%@page import="training.hib.dao.DoctorPatientDAO"%>
<%@page import="java.util.HashSet"%>
<%@page import="training.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Doctor doctor= (Doctor) session.getAttribute("doctorObj");
	HashSet doctorSet= new HashSet();
	doctorSet.add(doctor);
%>
<jsp:useBean id="patient" class="training.entity.Patient">

	<jsp:setProperty name="patient" property="*" />
</jsp:useBean>

<%
	patient.setDoctors(doctorSet);

System.out.println(patient.printDrDetail());
DoctorPatientDAO.addPatient(patient);

response.sendRedirect("viewPatient.jsp");

%>