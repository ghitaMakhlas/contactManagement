<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

<div class="container">
  <spring:url value="/api/contacts/insert" var="saveURL" />
  <h2>
  Contact
  <spring:url value="/api/cancelInsertOrUpdate" var="cancelURL" />
  <a class="btn btn-primary" href="${cancelURL}" role="button" >Cancel</a>
  </h2>
  <form:form modelAttribute="contactForm" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Prénom</label>
    <form:input path="firstName" cssClass="form-control" id="firstName" />
   </div>
   <div class="form-group">
    <label>Nom</label>
    <form:input path="lastName" cssClass="form-control" id="lastName" />
   </div>
   <div class="form-group">
    <label>Email</label>
    <form:input path="email" cssClass="form-control" id="email" />
   </div>
   <div class="form-group">
    <label>Promotion</label>
    <form:input path="graduationYear" cssClass="form-control" id="graduationYear" />
   </div>
   <div class="form-group">
    <label>Poste</label>
    <form:input path="companyPosition" cssClass="form-control" id="companyPosition" />
   </div>
   <button type="submit" class="btn btn-primary">Ajouter</button>
  </form:form>
  </div>
	
</body>
</html>