getProductInfo();
function getProductInfo(){
  var urlParams = new URLSearchParams(window.location.search);
  console.log("https://iacgroep3.herokuapp.com/restservices/product/"+urlParams.get('id'));
	var uri = "https://iacgroep3.herokuapp.com/restservices/product/"+urlParams.get('id');
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
            console.log(response);
	            $.each(response, function(key, value){
                console.log(value);
                console.log(key);
	            });
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
