$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

if(sessionStorage.getItem("cart")!=null){
  var element = JSON.parse(sessionStorage.getItem("cart"));
  var el;
  for (el in element) {
    console.log(element[el].price);
    $("#productsInCard").append(
      "<div class=\"row\">"+
        "<div class=\"col s3 m3\" id=\"productImage\"><img class=\"materialboxed\" width=\"150\" src=\"" +element[el].image +"\"></div>"+
        "<div class=\"col s2 m2\" id=\"productTitle\"><p>"+ element[el].name +"</p></div>"+
        "<div class=\"col s2 m2\" id=\"productPrice\"><p>"+ element[el].price +"</p></div>"+
        "<div class=\"col s2 m2\" id=\"productPrice\"><p>"+ element[el].amount +"</p></div>"+
        "<div class=\"col s3 m3\"><button class=\"waves-effect waves-light btn-large red darken-2\" type=\"button\" id=\"removeProduct"+element[el].id+"\">Remove Product</button></div>"+
      "</div>"
    );
    var wichProduct = "#removeProduct"+element[el].id;
    document.getElementById(wichProduct).onclick = removeProduct(element[el].id);
  }
}
else{
  //ERROR HANDLING FOR EMPTY SHOPPING CARD?
}

removeProduct(id){
  var element = JSON.parse(sessionStorage.getItem("cart"));
  element = element.filter(function(el) {
    return el.id !== id;
  });
  var jsonStr = JSON.stringify( element );
  sessionStorage.setItem("cart", jsonStr);
}
