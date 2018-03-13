Producten();
function Producten(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/product/get/all";
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
	            $.each(response, function(key, value){
	            	$("#ProductCards").append(
									"<div class=\"col s12 m6 l3\">"+
							      "<div class=\"card small\">"+
							        "<div class=\"card-image\">"+
							          "<img id=\"product-img\" src=\""+value.image+"\"/>"+
							          "<span id=\"product-title\" class=\"card-title blue-text text-darken-4\">"+ value.name +"</span>"+
							        "</div>"+
							        "<div class=\"card-content\">"+
							          "<p id=\"card-content\">"+
												value.description+
												"</p>"+
							        "</div>"+
							       "<div class=\"card-action\">"+
							          "<a href=\"https://iacgroep3.herokuapp.com/get/?id="+value.id+"\">Details</a>"+
							        "</div>"+
							      "</div>"+
							   "</div>");
	            });
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
