$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

OfferProducten();
function OfferProducten(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/offer/all";
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
	            $.each(response, function(key, value){
                var uri = "https://iacgroep3.herokuapp.com/restservices/product/"+value.product_id;
              	 $.ajax(uri, {
              	        type: "GET",
              	        beforeSend: function(xhr){
              	        	var token = window.sessionStorage.getItem("sessionToken");
              	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
              	        },
              	        success: function(response) {
                          $("#offerProducts").append(
          									"<div class=\"col s12 m6 l3\">"+
          							      "<div class=\"card large\">"+
          							        "<div class=\"card-image\">"+
          							          "<img id=\"product-img\" src=\""+response.image+"\"/>"+

          							        "</div>"+
          							        "<div class=\"card-content\">"+
                                  "<span id=\"product-title\" class=\"card-title grey-text text-darken-4\">Now just!: &euro;"+ response.price +"</span>"+
          							          "<p class=\"card-subtitle grey-text text-darken-2\">"+
          												response.name+
          												"</p>"+
          							        "</div>"+
          							       "<div class=\"card-action\">"+
          							          "<a href=\"https://iacgroep3.herokuapp.com/productinfo.html\?id="+ response.id +"\">Details</a>"+
          							        "</div>"+
          							      "</div>"+
          							   "</div>");
              	        },
              	        error: function(response) {
              	             $("#errorHandling").html("The server could not get any products corresponding with the offers from our database.");;
              	        }
              	    });
	            });
	        },
	        error: function(response) {
	             $("#errorHandling").html("The server could not get any products with offers from our database.");;
	        }
	    });
}
