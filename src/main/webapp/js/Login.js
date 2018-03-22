$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});
/*
$('#login').click(function(event){
	var data = $('#loginForm').serialize();
	$.post("https://iacgroep3.herokuapp.com/restservices/authentication/authenticate", data, function(response){
		console.log(response);
		var tokenAndId = JSON.parse(response);
		console.log(tokenAndId);
		console.log(tokenAndId.id);
		console.log(tokenAndId.token);
		window.sessionStorage.setItem("sessionToken", tokenAndId.token);
		window.sessionStorage.setItem("id", tokenAndId.id);
	}).fail(function(jqXHR, textStatus, errorThrown){
		console.log(textStatus);
		console.log(errorThrown);
		console.log("Try logging in again");
	});
});*/

$('#login').click(function(event){
  sessionStorage.setItem("Product_id", urlParams.get('id'));
	var uri = "https://iacgroep3.herokuapp.com/restservices/authentication/authenticate";
	 $.ajax(uri, {
	        type: "POST",
          data: $("#loginForm").serialize(),
	        success: function(response) {
            console.log(response);
        		var tokenAndId = JSON.parse(response);
        		console.log(tokenAndId);
        		console.log(tokenAndId.id);
        		console.log(tokenAndId.token);
        		window.sessionStorage.setItem("sessionToken", tokenAndId.token);
        		window.sessionStorage.setItem("id", tokenAndId.id);
          },
	        error: function(response) {
            console.log(textStatus);
            console.log(errorThrown);
            console.log("Try logging in again");
	        }
	    });
    });
