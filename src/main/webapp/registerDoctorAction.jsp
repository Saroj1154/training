<%@page import="training.hib.dao.DoctorPatientDAO"%>
<%@page import="java.util.HashSet"%>
<%@page import="training.entity.Doctor"%>
<%@ page import="training.hib.dao.DoctorDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="doctor" class="training.entity.Doctor">

	<jsp:setProperty name="doctor" property="*" />
</jsp:useBean>

<%


System.out.println(doctor);
DoctorDAO.addDoctor(doctor);

response.sendRedirect("drLogin.jsp");

%>