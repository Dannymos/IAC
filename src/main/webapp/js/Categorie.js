info();
function info(){
	console.log("test");
	var uri = "https://iacgroep3.herokuapp.com/restservices/categories/main";
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
	            $.each(response, function(key, value){
	            	$("#cards").append(
									"<div class=\"col s12 m6 l3\">"+
							      "<div class=\"card small\">"+
							        "<div class=\"card-image\">"+
							          "<img id=\"product-img\" src=\""+value.picture+"\"/>"+
							          "<span id=\"product-title\" class=\"card-title blue-text text-darken-4\">"+ value.name +"</span>"+
							        "</div>"+
							        "<div class=\"card-content\">"+
							          "<p id=\"card-content\">"+
												value.description+
												"</p>"+
							        "</div>"+
							       "<div class=\"card-action\">"+
							          "<a href=\"#\">Details</a>"+
							        "</div>"+
							      "</div>"+
							   "</div>");
								console.log(value.picture);
	            });
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}
