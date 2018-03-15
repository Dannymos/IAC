$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

getProductInfo();
function getProductInfo(){
  var urlParams = new URLSearchParams(window.location.search);
  sessionStorage.setItem("Product_id", urlParams.get('id'));
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
            $("#productExplanation").html("<h5>"+ response.explanation +"</h5>");
            $("#productPrice").html("<h5 class=\"teal-text text-darken-2\">"+ response.price +"</h5>");
	        },
	        error: function(response) {
	            $("#response").text("RIP!");
	        }
	    });
}

$('#addProductButton').click(function(event){
  var uri = "https://iacgroep3.herokuapp.com/restservices/product/"+sessionStorage.getItem("Product_id");
   $.ajax(uri, {
          type: "GET",
          beforeSend: function(xhr){
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader('Authorization', 'Bearer ' + token);
          },
          success: function(response) {
            var amount = parseInt($("#amount").val());
            if(sessionStorage.getItem("cart")==null){
              var element = [{id: response.id, amount: amount, price: response.price, image: response.image}];
              console.log(element);
              var jsonStr = JSON.stringify( element );
              sessionStorage.setItem("cart", jsonStr);
            }
            else{
              var element = JSON.parse(sessionStorage.getItem("cart"));
              console.log(element);
              element.push({id: response.id, amount: amount, price: response.price, image: response.image});
              var jsonStr = JSON.stringify( element );
              sessionStorage.setItem("cart", jsonStr);
            }
          },
          error: function(response) {
              $("#response").text("RIP!");
          }
      });
});
