getProductInfo();
function getProductInfo(){
  var urlParams = new URLSearchParams(window.location.search);
	var uri = "https://iacgroep3.herokuapp.com/restservices/product/"+urlParams.get('id');
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
            $("#productTitle").html("<h3>"+ response.name +"</h3>");
            $("#productPic").html("<img class=\"materialboxed\" width=\"450\" src=\""+response.image+"\">");
            $("#productExplanation").html("<p>"+ response.explanation +"</p>");
            $("#productPrice").html("<h5 class=\"teal-text text-darken-2\">"+ response.price +"</h5>");
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
