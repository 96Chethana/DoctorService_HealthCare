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

//LAB 09 

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

	// If valid------------------------
	var type = ($("#hidDocIDSave").val() == "") ? "POST" : "PUT"; 
	$.ajax(
	{
		
		url : "DoctorFeedbackAPI",
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
		$("#date").val($(this).closest("tr").find('td:eq(1)').text());
		$("#message").val($(this).closest("tr").find('td:eq(2)').text());

	});



//implementing the delete button click handler
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "DoctorFeedbackAPI",
		type : "DELETE",
		data : "feedback_id=" + $(this).data("docid"),
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
	

	// Doctor name
	if ($("#f_name").val().trim() == "") {
		return "Insert Doctor Name.";
	}
	
	//Date
	if ($("#date").val().trim() == "") {
		return "Insert Date.";
	}
	
	
	//message
	if ($("#message").val().trim() == "") {
		return "Insert Message.";
	}	
	
	return true;
	
	
}

