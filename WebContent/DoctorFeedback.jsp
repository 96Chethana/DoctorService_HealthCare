<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>    
<%@ page import="com.heathCareDoctor.Class.DoctorFeedback" %> 
<%@ page import="com.healthCareDoctor.Util.DoctorDB" %>  <%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.sql.*" %> 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%> 

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">  
<script src="component/js/jquery-3.5.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="component/js/DoctorFeedback.js"></script>

</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm">
				<h3>
					Feedback Adding Form <small class="text-muted">Doctor Side</small>
				</h3>

				<form id="FeedbackFrom" name="FeedbackFrom" method="post" action="DoctorFeedback.jsp">

					<div class="form-group col-md-6">
						<div class="form-group ">
							
							<label for="firstname">First Name</label> <input type="text"
								class="form-control" id="f_name" name="f_name"
								placeholder="Enter Name" required>
					</div>

					<div class="form-group">
							
							<label for="Date">Date</label> <input type="text"
							class="form-control" id="date" name="date"
							placeholder="Enter Date" required>
					</div>
    					
    				<div class="form-group">						
							<label for=Message>Message</label> <input type="text"
							class="form-control" id="message" name="message"
							placeholder="Enter message" required>
					</div>
					
    					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
						<input id="hiFdSave" name="hiFdSave" type="hidden" value="">			
    					
    				</div>
				</form>

			</div>
		</div>
		
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>

		<div class="row">
			<div class="col-sm">
				<div id="divFeedbackGrid">
					<% 
 
						DoctorFeedback feedback = new DoctorFeedback();
	 					out.print(feedback.readDoctorFeedback());
										
 					%>
				</div>
			</div>
		</div>
	</div>

<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>