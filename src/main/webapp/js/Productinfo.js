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
              var element = {};
              element.id = response.id;
              element.quantity = amount;
              element.price = response.price;
              element.push({element: element});
              console.log(element);
              var jsonStr = JSON.stringify( element );
              sessionStorage.setItem("cart", jsonStr);
            }
            else{
              var element = JSON.parse(sessionStorage.getItem("cart"));
              console.log(element);
              var element2 = {}
              element2.id = response.id;
              element2.quantity = amount;
              element2.price = response.price;
              element2.push({element: element});
              element.push(element2);
            }

            /*if(sessionStorage.getItem(cart)==null){
              var amount = $("#amount").val();

              var cart = {
                  id:response.id,
                  item: response.name,
                  price: response.price,
                  amount: amount
              };

              var jsonStr = JSON.stringify( cart );

              sessionStorage.setItem( "cart", jsonStr );
              // now the cart is {"item":"Product name","price":35.50,"amount":2}
            }
            else{

            }*/
          },
          error: function(response) {
              $("#response").text("RIP!");
          }
      });
});
