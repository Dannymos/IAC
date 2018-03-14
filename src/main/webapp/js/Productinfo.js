getProductInfo();
function getProductInfo(){
  urlParams.get('id')
  href = window.location.href;
	var uri = href;
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
	            $.each(response, function(key, value){
                console.log(value.image)
	            });
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
