$('#login').click(function(event){
	var data = $('#loginForm').serialize();

	$.post("restservices/authentication/authenticate", data, function(response){
		window.sessionStorage.setItem("sessionToken", response);
	}).fail(function(jqXHR, textStatus, errorThrown){
		console.log(textStatus);
		console.log(errorThrown);
	})/*.done(function(){
		var uri = "URI THAT GETS DATA OF MEMBER";
		 $.ajax(uri, {
		        type: "POST",
		        data: $('#loginForm').serialize(),
		        beforeSend: function(xhr){
		        	var token = window.sessionStorage.getItem("sessionToken");
		        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
		        },
		        success: function(response) {
		            $.each(response, function(key, value){
		            	window.sessionStorage.setItem("PUTVALUEHERE", value["PUTVALUEHERE"]);
		            		window.location.replace("https://iacgroep3.herokuapp.com");
		            });
		        },
		        error: function(response) {
		            $("#response").text("RIP!");
                window.location.replace("https://iacgroep3.herokuapp.com"); //REMOVE WHEN URI ACTUALLY CONTAINS GOOD URI
		        }
		    });
	});*/


});
