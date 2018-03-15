$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});


/* Converts a JSON string to a JavaScript object
 * @param str String the JSON string
 * @returns obj Object the JavaScript object
 */

_toJSONObject: function( str ) {
    var obj = JSON.parse( str );
    return obj;
},

/* Converts a JavaScript object to a JSON string
 * @param obj Object the JavaScript object
 * @returns str String the JSON string
 */

_toJSONString: function( obj ) {
    var str = JSON.stringify( obj );
    return str;
}


/* Add an object to the cart as a JSON string
 * @param values Object the object to be added to the cart
 * @returns void
 */

_addToCart: function( values ) {
    var cart = this.storage.getItem( this.cartName );
    var cartObject = this._toJSONObject( cart );
    var cartCopy = cartObject;
    var items = cartCopy.items;
    items.push( values );

    this.storage.setItem( this.cartName, this._toJSONString( cartCopy ) );
}


getProductInfo();
function getProductInfo(){
  var urlParams = new URLSearchParams(window.location.search);
  sessionStorage.setItem("Product_id", urlParams.get('id'));
  console.log("https://iacgroep3.herokuapp.com/restservices/product/"+urlParams.get('id'));
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
  console.log("https://iacgroep3.herokuapp.com/restservices/product/"+sessionStorage.getItem("Product_id"));
  var uri = "https://iacgroep3.herokuapp.com/restservices/product/"+sessionStorage.getItem("Product_id");
   $.ajax(uri, {
          type: "GET",
          beforeSend: function(xhr){
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader('Authorization', 'Bearer ' + token);
          },
          success: function(response) {
            if(sessionStorage.getItem("cartName") == null){
              var amount = $("#amount").val();

              var cart = {
                  id:response.id,
                  item: response.name,
                  price: response.price,
                  amount: amount
              };

              var jsonStr = JSON.stringify( cart );

              sessionStorage.setItem( "cartName", jsonStr );
              // now the cart is {"item":"Product name","price":35.50,"amount":2}
            }
            else{
              this._addToCart({
                id:response.id,
                item: response.name,
                price: response.price,
                amount: amount
              });
            }
          },
          error: function(response) {
              $("#response").text("RIP!");
          }
      });
});
