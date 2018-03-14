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
                $("#productPic").html("<img class=\"materialboxed\" width="450" src=\""+response.image+"\">");
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
