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
          "<div class=\"col s3 m3\" id=\"productImage\"><img class=\"materialboxed\" width=\"150\" src=\"" +element[el].image +"\"></div>"+
          "<div class=\"col s2 m2\" id=\"productTitle\"><p>"+ element[el].name +"</p></div>"+
          "<div class=\"col s2 m2\" id=\"productPrice\"><p>"+ element[el].price +"</p></div>"+
          "<div class=\"col s2 m2\" id=\"productPrice\"><p>"+ element[el].amount +"</p></div>"+
        "</div>"
      );
      var totalPrice = totalPrice + Number(element[el].price);
    }
    $("#productsInCard").append(
      "<div class=\"row\">"+
        "<div class=\"divider col s12 m12\"></div>"+
        "<div class=\"col s4 m4 push-m8\">&euro;"+ totalPrice +"</div>"+
      "</div>"
    );
  }
}
