$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});
var urlParams = new URLSearchParams(window.location.search);
checkShoppingCard();
getProductInfo();
function getProductInfo(){
  sessionStorage.setItem("Product_id", urlParams.get('id'));
	var uri = "https://iacgroep3.herokuapp.com/restservices/product/"+urlParams.get('id');
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
            $("#productTitle2").html(response.name);
            $("#productTitle").html("<h3>"+ response.name +"</h3>");
            $("#productPic").html("<img class=\"materialboxed\" width=\"450\" src=\""+response.image+"\">");
            $("#productExplanation").html("<h5>"+ response.explanation +"</h5>");
            $("#productPrice").html("<h5 class=\"teal-text text-darken-2\">&euro;"+ response.price +"</h5>");
            if("offer" in response){
              $("#priceReduction").html("<h5 class=\"teal-text text-darken-2\">"+ response.offer.reduction +"&#37;</h5>");
            }
            else{
              $("#priceReduction").html("<h5 class=\"teal-text text-darken-2\">No price reduction</h5>");
            }
	        },
	        error: function(response) {
	            $("#errorHandling").html("The server could not provide you with further information about the product. Try to login again or selecting the product again.");
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
            console.log(amount);
            if(amount == NaN){
               $("#errorHandling").html("Please give a valid amount");
               console.log("been here");
            }
            else if(amount < 1){
              $("#errorHandling").html("Please give a valid amount");
              console.log("been here to");
            }
            else{
              if(sessionStorage.getItem("cart")==null){
                var element = [{id: response.id, amount: amount, price: response.price, image: response.image, name: response.name}];
                console.log(element);
                var jsonStr = JSON.stringify( element );
                sessionStorage.setItem("cart", jsonStr);
              }
              else{
                var element = JSON.parse(sessionStorage.getItem("cart"));
                console.log(element);
                element.push({id: response.id, amount: amount, price: response.price, image: response.image, name: response.name});
                var jsonStr = JSON.stringify( element );
                sessionStorage.setItem("cart", jsonStr);
              }
              checkShoppingCard();
            }
          },
          error: function(response) {
            $("#errorHandling").html("The server could not add this product to your card. See if its already added or try again later.");
          }
      });
});

function checkShoppingCard(){
  var element = JSON.parse(sessionStorage.getItem("cart"));
  var el;
  for (el in element) {
    if(element[el].id == urlParams.get('id')){
      $("#addProductButton").remove();
      $("#buttonDiv").html("<button class=\"disabled btn-large\" type=\"button\" id=\"addProductButton\">Already added</button>")
    }
  }
}
