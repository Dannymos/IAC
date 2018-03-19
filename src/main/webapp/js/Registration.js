$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

$("#registerMember").click(function(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/user/add";
$.ajax(uri, {
    type: "POST",
    data: $("#registerForm").serialize(),
    beforeSend: function(xhr){
    	var token = window.sessionStorage.getItem("sessionToken");
    	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
    },
    success: function(response) {
      if(sessionStorage.getItem("performingOrder")){
        window.location.replace("OrderConfirment.html");
      }
      else{
        window.location.replace("index.html");
      }
    },
    error: function(response) {
        $("#errorHandling").html("Adding you to our database went wrong. please try again later.");
    }
});
});
