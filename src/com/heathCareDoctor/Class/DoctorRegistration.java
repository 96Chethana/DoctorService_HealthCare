package com.heathCareDoctor.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.healthCareDoctor.Util.DoctorDB;

public class DoctorRegistration {

	DoctorDB db = new DoctorDB();
	Connection connection = db.getCon();
	
	
	//Create Method For Insert Doctor Details
		public String insertDoctorDeatails(String f_name, String l_name, String age,String email, String phoneNo, String nic, String hospital_name,String specialization)
		{
			
			String output = ""; 
			
			try {
				
				// create a prepared statement    
				String query = " insert into doctor (`id`,`f_name`,`l_name`,`age`,`email`,`phoneNo`,`nic`,`hospital_name`,`specialization`)" 
				+ " values (?,?,?,?,?,?,?,?,?)"; 
				
				PreparedStatement preparedStmt = connection.prepareStatement(query); 
				
				 System.out.println("Hello");	
				
				//binding values    
				preparedStmt.setInt(1, 0);      
				preparedStmt.setString(2,f_name);    
				preparedStmt.setString(3,l_name);       
				preparedStmt.setInt(4, Integer.parseInt(age)); 
				preparedStmt.setString(5,email);
				preparedStmt.setInt(6, Integer.parseInt(phoneNo)); 
				preparedStmt.setString(7,nic);
				preparedStmt.setString(8,hospital_name);
				preparedStmt.setString(9,specialization);			
				
				// execute the statement    
				preparedStmt.execute();    
				
				String newDoctor = readDoctorDetails();
		        output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
				
			} catch (Exception e) {
				// TODO: handle exception
				output = "{\"status\":\"error\", \"data\": \"Error while inserting the doctor.\"}";
		        System.err.println(e.getMessage()); 
				
			}
			return output; 
			
		}
		
			//Create method for view Doctor Deatils
		public String readDoctorDetails()  
		{
			String output = ""; 
			
			try {
				
				// Prepare the html table to be displayed 
				   output = "<table border=\"1\">"
				   		+ "<tr>"
				   		+ "<th>First Name</th>"
				   		+ "<th>Last Name</th>"
				   		+ "<th>Age</th>"
				   		+ "<th>Email</th>"
				   		+ "<th>Phone No</th>"
				   		+ "<th>NIC</th>"
				   		+ "<th>Hospital_name</th>"
				   		+ "<th>Specialization</th>"
				   		+ "<th>Update</th>"
				   		+ "<th>Remove</th>"
				   		+ "</tr>"; 
				
				   String query = "select * from doctor";    
				   Statement stmt = connection.createStatement();    
				   ResultSet rs = stmt.executeQuery(query); 
				   
				
				// iterate through the rows in the result set   
				   while (rs.next()) {
					   String id = Integer.toString(rs.getInt("id"));     
					   String f_name = rs.getString("f_name");     
					   String l_name = rs.getString("l_name");     
					   String age = Integer.toString(rs.getInt("age"));
					   String email = rs.getString("email"); 
					   String phoneNo = Integer.toString(rs.getInt("phoneNo")); 
					   String nic = rs.getString("nic"); 
					   String hospital_name = rs.getString("hospital_name"); 
					   String specialization = rs.getString("specialization"); 
					   
					   
					// Add into the html table     
					   output += "<tr><td><input id='hiddocIDUpdate' name='hiddocIDUpdate' type='hidden' value='"+ id + "'>" + f_name + "</td>";    
					   output += "<td>" + l_name + "</td>";     
					   output += "<td>" + age + "</td>";     
					   output += "<td>" + nic + "</td>"; 
					   output += "<td>" + email + "</td>"; 
					   output += "<td>" + phoneNo + "</td>"; 
					   output += "<td>" + hospital_name + "</td>"; 
					   output += "<td>" + specialization + "</td>"; 
					   
					// buttons     
					   output += "<td><input name= 'btnUpdate' type= 'button' value= 'Update' class='btnUpdate btn btn-secondary'></td>"
					   								+ "<td><input name='btnRemove' type='button' value= 'Remove' class='btnRemove btn btn-danger' data-docid='" + id + "'>" + "</td></tr>";
					   
				   }
				   
				// Complete the html table   
				   output += "</table>";   
				   
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while reading the doctor details.";    
				System.err.println(e.getMessage()); 
			}
			return output; 
		}

		
			//Create method for update Doctor Deatils
			public String updateDoctorDetails(String id,String f_name, String l_name, String age,String email, String phoneNo, String nic, String hospital_name,String specialization)  
			{   
				String output = "";
				
				try {
						// create a prepared statement    
						String query = "UPDATE doctor SET f_name=?,l_name=?,age=?,email=?,phoneNo=?,nic=?,hospital_name=?,specialization=?  WHERE id=?"; 
						 
						PreparedStatement preparedStmt = connection.prepareStatement(query); 
						 
						//binding values   
						preparedStmt.setString(1, f_name);    
						preparedStmt.setString(2, l_name);       
						preparedStmt.setInt(3, Integer.parseInt(age)); 
						preparedStmt.setString(4, email);
						preparedStmt.setInt(5, Integer.parseInt(phoneNo)); 
						preparedStmt.setString(6, nic);
						preparedStmt.setString(7, hospital_name);
						preparedStmt.setString(8, specialization);
						preparedStmt.setInt(9, Integer.parseInt(id));  
						
						// execute the statement    
						preparedStmt.execute();    
						
						 String newDoctor = readDoctorDetails();
					       output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
						
				} catch (Exception e) {
					// TODO: handle exception
					
					output = "{\"status\":\"error\", \"data\":\"Error while updating the doctor.\"}";
					System.err.println(e.getMessage()); 
					
				}
				   return output; 	
			}
		
			//Create method for Delete Doctor Deatils
			public String deleteDoctorDetails(String id)  {   
				
				String output = ""; 
				
				try {
					 	// create a prepared statement    
						String query = "delete from doctor where id=?"; 
						
						PreparedStatement preparedStmt = connection.prepareStatement(query); 
						 
						 // binding values    
						preparedStmt.setInt(1, Integer.parseInt(id)); 
						
						// execute the statement    
						preparedStmt.execute();    
						
						String newDoctor = readDoctorDetails();
					    output = "{\"status\":\"success\", \"data\": \"" + newDoctor + "\"}";
						
					
				} catch (Exception e) {
					// TODO: handle exception
					output = "{\"status\":\"error\", \"data\":\"Error while deleting  the doctor.\"}";
					System.err.println(e.getMessage());   
					
				}
				   return output; 		
			}

}
