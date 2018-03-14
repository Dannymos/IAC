Producten();
function getProductInfo(ID){
	var uri = "https://iacgroep3.herokuapp.com/restservices/product/get/all";
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
	            $.each(response, function(key, value){

	            });
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
