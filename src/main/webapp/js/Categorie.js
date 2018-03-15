$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

Categorieinfo();
function Categorieinfo(){
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
							      "<div class=\"card large\">"+
							        "<div class=\"card-image\">"+
							          "<img id=\"product-img\" src=\""+value.picture+"\"/>"+

							        "</div>"+
							        "<div class=\"card-content\">"+
                        "<span id=\"product-title\" class=\"card-title grey-text text-darken-4\">"+ value.name +"</span>"+
                        "<p class=\"card-subtitle grey-text text-darken-2\">"+
												value.description+
												"</p>"+
							        "</div>"+
							       "<div class=\"card-action\">"+
							          "<a href=\"https://iacgroep3.herokuapp.com/categorie_producten.html?id="+value.id+"\">Details</a>"+
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
