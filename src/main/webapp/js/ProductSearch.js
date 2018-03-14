Producten();
function Producten(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/product/all";
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
							      "<div class=\"card large\">"+
							        "<div class=\"card-image\">"+
							          "<img id=\"product-img\" src=\""+value.image+"\"/>"+

							        "</div>"+
							        "<div class=\"card-content\">"+
                        "<span id=\"product-title\" class=\"card-title grey-text text-darken-4\">"+ value.price +"</span>"+
							          "<p class=\"card-subtitle grey-text text-darken-2\">"+
												value.name+
												"</p>"+
							        "</div>"+
							       "<div class=\"card-action\">"+
							          "<a href=\"https://iacgroep3.herokuapp.com/Productinfo.html\">Details</a>"+
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
