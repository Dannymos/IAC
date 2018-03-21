$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

var element = JSON.parse(sessionStorage.getItem("cart"));
var totalPrice = 0;
if(element !== null){
  if(element.length > 0){
    var el;
    for (el in element) {
      $("#productsInCard").append(
        "<div class=\"row\">"+
          "<div class=\"col s12 m3\" id=\"productImage\"><img class=\"materialboxed\" width=\"150\" src=\"" +element[el].image +"\"></div>"+
          "<div class=\"col s12 m3\" id=\"productTitle\"><p>"+ element[el].name +"</p></div>"+
          "<div class=\"col s12 m3\" id=\"productPrice\"><p>Price: &euro;"+ element[el].price +"</p></div>"+
          "<div class=\"col s12 m3\" id=\"productPrice\"><p>Amount: "+ element[el].amount +"</p></div>"+
        "</div>"
      );
      var totalPrice = totalPrice + Number(element[el].price);
    }
    $("#productsInCard").append(
      "<div class=\"row\">"+
        "<div class=\"divider col s12 m12\"></div>"+
        "<div class=\"col s12 m6 push-m6\"><h5 class=\"teal-text text-darken-2\">Grand total: &euro;"+ totalPrice +"</h5></div>"+
      "</div>"
    );
  }
}

$('#orderConfirmed').click(function(event){
  //ADD THEM ORDERS M8
});
