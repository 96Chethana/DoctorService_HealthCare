package com.heathCareDoctor.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.healthCareDoctor.Util.DoctorDB;

public class DoctorFeedback {

	DoctorDB db = new DoctorDB();
	Connection connection = db.getCon();
	
	public String insertDoctorFeedback(String f_name, String date, String message)  
	{   
		
		String output = ""; 
		
		try {
			
				// create a prepared statement    
				String query = " insert into doctorfeedback (`feedback_id`,`f_name`,`date`,`message`)" + " values (?, ?, ?, ?)"; 
				
				
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				
				//binding values    
				preparedStmt.setInt(1, 0);    
				preparedStmt.setString(2, f_name);    
				preparedStmt.setString(3, date);     
				preparedStmt.setString(4, message); 
				
				// execute the statement    
				preparedStmt.execute();    
				
				String newFeedback = readDoctorFeedback();
				output = "{\"status\":\"success\",\"data\": \"" + newFeedback + "\"}";
				System.out.println("Insert success Output  ::" + output);
				
		} catch (Exception e) {
			// TODO: handle exception
			output = "{\"status\":\"error\",\"data\": \" Error while DoctorFeedbacks Details Inserting.\"}";
			System.out.println("Insert Error Output  ::" + output);
			System.err.println("Error while Insert the feedback Details:" + e.getMessage());
			
		}
		return output; 
		
	}
	
	
	public String readDoctorFeedback()  
	{
		String output = ""; 
		
		try {
			
				String query = "select * from doctorfeedback";  
		
				// Prepare the html table to be displayed 
				   output = "<table class=\"table table-striped\" border=\"1\">"
				   		+ "<tr>"
				   		+ "<th>Name</th>"
				   		+ "<th>Date</th>"
				   		+ "<th>Message</th>"
				   		+ "<th>Update</th>"
				   		+ "<th>Remove</th>"
				   		+ "</tr>"; 
				
				   Statement stmt = connection.createStatement();    
				   ResultSet rs = stmt.executeQuery(query); 
				   
				
				// iterate through the rows in the result set   
				   while (rs.next()) {
					   String feedback_id = Integer.toString(rs.getInt("feedback_id"));     
					   String f_name = rs.getString("f_name");     
					   String date = rs.getString("date");       
					   String message = rs.getString("message"); 
					   
					   
					// Add into the html table 
					   
					   output += "<tr>";
					   output += "<td><input id='hidFeedbackIdUpdate' name='hidFeedbackIdUpdate' type='hidden' value='"+feedback_id+"'>" +f_name + "</td>";  
					   output += "<td>" + date + "</td>";     
					   output += "<td>" + message + "</td>";     
						   
						// buttons     
						output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>";      				
						output += "<td><input name='btnRemove' type='button' value='Remove' class='btn btn-danger' data-feedback_id='"+ feedback_id + "'>"+"</td>";
						output += "</tr>"; 	
	   					   
			   }
			   
			// Complete the html table   
			   output += "</table>";   
			   
		} catch (Exception e) {
			// TODO: handle exception
			output = "Error while reading the doctor feedback.";    
			System.err.println(e.getMessage()); 
		}
		return output; 
	}

	//
	public String updateDoctorFeedback(String hiFdSave, String f_name, String date, String message)  
	{   
		
	System.out.println(hiFdSave+" :::: "+f_name+" :::: "+date+" :::: "+message );
		String output = "";
		
		try {
			    String query = "UPDATE doctorfeedback SET f_name=?,date=?,message=? WHERE feedback_id=?"; 
			
				// create a prepared statement    
				 
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				 
			
				preparedStmt.setString(1, f_name);    
				preparedStmt.setString(2, date);    
				preparedStmt.setString(3, message);    
				preparedStmt.setInt(4, Integer.parseInt(hiFdSave));  
				
				// execute the statement    
				preparedStmt.execute();    
				
				String newFeedback = readDoctorFeedback();
				output = "{\"status\":\"success\",\"data\": \"" + newFeedback + "\"}";
				System.out.println("Insert success Output  ::" + output);
				
		} catch (Exception e) {
			// TODO: handle exception
			
			output = "{\"status\":\"error\",\"data\": \" Error while DoctorFeedback Details Updating.\"}";
			System.err.println("Error while updating the feedback Details::  " + e.getMessage());
			
		}
		   return output; 	
	}
	
	
	public String deleteDoctorFeedback(String feedback_id)  {   
		
		System.out.println("Pass feedback_id  " + feedback_id);
		
		String output = ""; 
		
		try {
			
				String query = "delete from doctorfeedback where feedback_id=?"; 	
			 
				// create a prepared statement    
				
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				 
				 // binding values    
				preparedStmt.setInt(1, Integer.parseInt(feedback_id)); 
				
				// execute the statement    
				preparedStmt.execute();    			 

				String newFeedback = readDoctorFeedback();
				output = "{\"status\":\"success\",\"data\": \"" + newFeedback + "\"}";
			
			
		} catch (Exception e) {
			// TODO: handle exception
			output = "{\"status\":\"error\",\"data\": \" Error while DoctorFeedbacks Details Deleting.\"}";
			System.err.println("Error while Delete the feedback Details::" + e.getMessage());
			
		}

		   return output; 		
	}
	
}
