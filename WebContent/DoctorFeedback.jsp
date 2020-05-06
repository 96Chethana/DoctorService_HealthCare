<%@ page import="com.heathCareDoctor.Class.DoctorFeedback" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Management</title>
<!-- <link rel="stylesheet" href="Views/bootstrap.min.css"> -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script src="component/js/DoctorFeedback.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
	<h1>Doctor Feedback</h1>
	<br>
	<form id="formDoctor" name="formDoctor">
		Doctor Name:
		<input id="f_name" name="f_name"  type="text"  class="form-control form-control-sm">
		

		<br>Date:
		<input id="date" name="date"  type="text"  class="form-control form-control-sm"> 
	
 		<br>Message:
		<input id="message" name="message"  type="text"  class="form-control form-control-sm"> 
		

		<br>
		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
		<input type="hidden" id="hidDocIDSave" name="hidDocIDSave" value="">
	
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
    <div id="alertError" class="alert alert-danger"></div>
    
    <br>
    <div id="divDoctorsGrid">
    	<%
    	
    		DoctorFeedback docObj = new DoctorFeedback();
    	   	out.print(docObj.readDoctorFeedback());
    	
    	%>	
    </div>
        
</div>
</div>
</div>
	

</body>
</html>