$('#login').click(function(event){
	var data = $('#loginForm').serialize();
	$.post("https://iacgroep3.herokuapp.com/restservices/authentication/authenticate", data, function(response){
		console.log(response);
		var tokenAndId = JSON.parse(response);
		console.log(tokenAndId);
		console.log(tokenAndId[0]);
		console.log(tokenAndId[1]);
		window.sessionStorage.setItem("sessionToken", tokenAndId[0]);
		window.sessionStorage.setItem("role", tokenAndId[1]);
	}).fail(function(jqXHR, textStatus, errorThrown){
		console.log(textStatus);
		console.log(errorThrown);
		console.log("Try logging in again");
	});
});
