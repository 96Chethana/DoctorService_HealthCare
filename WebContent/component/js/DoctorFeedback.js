$(document).ready(function()
		{
	if ($("#alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();

});

$(document).on("click", "#btnSave", function(event)
		{ 
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");


	var status = validateFeedbackForm();
	if(status!= true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}


	var type  = ($("#hiFdSave").val() == "") ? "POST" : "PUT";
	console.log(type)
	$.ajax(
			{
				url: "DoctorFeedbackAPI",
				type: type,
				data : $("#FeedbackFrom").serialize(),
				dataType :"text",
				complete : function(response, status)
				{
					onFeedbackSaveComplete(response.responseText, status);
					console.log(response.responseText)
					console.log("***************************************************************")
					console.log(status)
				}
			});
		});


$(document).on("click", ".btnUpdate", function (event) {
	$("#hiFdSave").val($(this).closest("tr").find('#hidFeedbackIdUpdate').val());
	$("#f_name").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#date").val($(this).closest("tr").find('td:eq(1)').text());
	$("#message").val($(this).closest("tr").find('td:eq(2)').text());

});


$(document).on("click", ".btnRemove", function (event) {
	
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");

	$.ajax(
			{
				url : "DoctorFeedbackAPI",
				type: "DELETE",
				data : "feedback_id=" + $(this).data("feedback_id") ,
				dataType :"text",
				complete : function(response, status)
				{
					onFeedbackDeleteComplete(response.responseText, status);
					console.log(response)
					console.log("***************************************************************")
					console.log(status)
				}
			})

})


function onFeedbackSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		console.log("results "+resultSet.status.trim());
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();

			$("#divFeedbackGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
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

	$("#hiFdSave").val("");
	$("#FeedbackFrom")[0].reset();
}

function onFeedbackDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divFeedbackGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}


function validateFeedbackForm() {
	
	if($("#f_name").val().trim() == "")
	{
		return "Insert First Name";
	}

	if($("#date").val().trim() == "")
	{
		return "Insert Date";
	}

	if($("#message").val().trim() == "")
	{
		return "Insert message";
	}
	
	return true;
}