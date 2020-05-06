//hide the divisions used to show the status messages on the page load.
//$(document).ready(function() {
	//if ($("#alertSuccess").text().trim() == "") {
	//	$("#alertSuccess").hide();
	//}
//$("#alertError").hide();
//});

$(document).ready(function() 
	{
	 	$("#alertSuccess").hide();
	
		$("#alertError").hide();
	
		
});

//implementing the save button click handler
$(document).on("click","#btnSave", function(event) {

	// Clear alerts---------------------

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateDoctorForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// LAB 10
	// If valid------------------------
	var type = ($("#hidDocIDSave").val() == "") ? "POST" : "PUT"; 
	$.ajax(
	{
		
		url : "DoctorRegistrationAPI",
		type : type,
		data : $("#formDoctor").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onSaveDoctorComplete(response.responseText, status);
		}
		
		
	});

});


//completing the saving function
function onSaveDoctorComplete(response, status){  
	if (status == "success") 
	{ 
			var resultSet = JSON.parse(response); 

			if (resultSet.status.trim() == "success")  
				{ 
				$("#alertSuccess").text("Successfully saved."); 
				$("#alertSuccess").show(); 

				$("#divDoctorsGrid").html(resultSet.data); 
				}
			else if (resultSet.status.trim() == "error") 
			{    $("#alertError").text(resultSet.data);   
				$("#alertError").show(); 
			} 

	} else if (status == "error") 
	{ 
		
			$("#alertError").text("Error while saving.");
			$("#alertError").show(); 
		} else 
			{  
				$("#alertError").text("Unknown error while saving..");
				$("#alertError").show(); 
			} 

$("#hidDocIDSave").val(""); 
$("#formDoctor")[0].reset();

}






// implementing the update button click handler
$(document).on("click", ".btnUpdate", function(event)
	{
		$("#hidDocIDSave").val($(this).closest("tr").find('#hiddocIDUpdate').val());
		$("#f_name").val($(this).closest("tr").find('td:eq(0)').text());
		$("#l_name").val($(this).closest("tr").find('td:eq(1)').text());
		$("#age").val($(this).closest("tr").find('td:eq(2)').text());
		$("#email").val($(this).closest("tr").find('td:eq(3)').text());
		$("#phoneNo").val($(this).closest("tr").find('td:eq(4)').text());
		$("#nic").val($(this).closest("tr").find('td:eq(5)').text());
		$("#hospital_name").val($(this).closest("tr").find('td:eq(6)').text());
		$("#specialization").val($(this).closest("tr").find('td:eq(7)').text());
	});



//implementing the delete button click handler
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "DoctorRegistrationAPI",
		type : "DELETE",
		data : "id=" + $(this).data("docid"),
		dataType : "text",
		complete : function(response, status) {
			onDoctorDeleteComplete(response.responseText, status);
		}
	});
});

//completing the delete function
function onDoctorDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divDoctorsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// validating the form
function validateDoctorForm(){
	

	// Doctor First name
	if ($("#f_name").val().trim() == "") {
		return "Insert Doctor First Name.";
	}
	
	// Doctor Last name
	if ($("#l_name").val().trim() == "") {
		return "Insert Doctor Last Name.";
	}
	
	//Doctor Age
	if ($("#age").val().trim() == "") {
		return "Insert Doctor Contact number.";
	}
	
	//checking if Age is numerical
	var tmpage= $("#age").val().trim();
	if (!$.isNumeric(tmpage)) {
		return "Insert a numerical value for Contact no.";
	}
	
	//Doctor Email
	if ($("#email").val().trim() == "") {
		return "Insert Doctor Email Address.";
	}
	
	//Checking if a valid email Address
	var tmpEmail = $("#email").val().trim();
	var re = /[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}/igm;
	if (! re.test(tmpEmail)){
		return "Insert a valid email address";
	}
	
	
	//Doctor Contact Number
	if ($("#phoneNo").val().trim() == "") {
		return "Insert Doctor Contact number.";
	}
	
	//checking if Contact number is numerical
	var tmpContact = $("#phoneNo").val().trim();
	if (!$.isNumeric(tmpContact)) {
		return "Insert a numerical value for Contact no.";
	}
	
	//Doctor NIC
	if ($("#nic").val().trim() == "") {
		return "Insert Doctor NIC.";
	}
	
	//Doctor Hospital
	if ($("#hospital_name").val().trim() == "") {
		return "Insert Doctor Hospital.";
	}

	
	//Doctor Specialization
	if ($("#specialization").val().trim() == "") {
		return "Insert Doctor Specialization.";
	}
	

	return true;
	
	
}
