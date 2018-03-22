$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

$('#login').click(function(event){
	var uri = "https://iacgroep3.herokuapp.com/restservices/authentication/authenticate";
	 $.ajax(uri, {
	        type: "POST",
          data: $("#loginForm").serialize(),
	        success: function(response) {
        		var tokenAndId = JSON.parse(response);
        		window.sessionStorage.setItem("sessionToken", tokenAndId.token);
        		window.sessionStorage.setItem("id", tokenAndId.id);
            window.sessionStorage.setItem("role", tokenAndId.role);
            window.location.replace("https://iacgroep3.herokuapp.com/Home.html");
          },
	        error: function(response) {
            console.log("Try logging in again");
            $("#wrongLogin").html("Wrong password email combination");
	        }
	    });
    });
