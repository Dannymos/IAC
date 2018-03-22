$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

$("#registerMember").click(function(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/user/register";
    data = $("#registerForm").serialize();
    alert(data);
    $.ajax(uri, {
    type: "POST",
    data: data,
    contentType: 'application/x-www-form-urlencoded',
    beforeSend: function(xhr){
    	var token = window.sessionStorage.getItem("sessionToken");
    	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
    },
    success: function(response) {
      if(sessionStorage.getItem("performingOrder")){
        sessionStorage.removeItem("performingOrder");
        window.location.replace("https://iacgroep3.herokuapp.com/OrderConfirment.html");
          console.log("Succesfully registered!");
      }
      else{
        window.location.replace("https://iacgroep3.herokuapp.com/index.html");                          
      }
    },
    error: function(response) {
        $("#errorHandling").html("Adding you to our database went wrong. please try again later.");
    }
});
});
