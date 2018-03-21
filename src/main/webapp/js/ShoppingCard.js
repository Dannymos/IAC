$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

if(sessionStorage.getItem("cart")!=="null"){
  var element = JSON.parse(sessionStorage.getItem("cart"));
  var el;
  for (el in element) {
    $("#productsInCard").append(
      "<div class=\"row\">"+
        "<div class=\"col s3 m3\" id=\"productImage\"><img class=\"materialboxed\" width=\"150\" src=\"" +element[el].image +"\"></div>"+
        "<div class=\"col s2 m2\" id=\"productTitle\"><p>"+ element[el].name +"</p></div>"+
        "<div class=\"col s2 m2\" id=\"productPrice\"><p>"+ element[el].price +"</p></div>"+
        "<div class=\"col s2 m2\" id=\"productPrice\"><p>"+ element[el].amount +"</p></div>"+
        "<div class=\"col s3 m3\"><button class=\"waves-effect waves-light btn-large red darken-2\" type=\"button\" id=\"removeProduct\" onclick=\"removeProduct("+ element[el].id +")\">Remove Product</button></div>"+
      "</div>"
    );
  }
}
else{
  $("#productsInCard").append(
    "<div class=\"row\">"+
      "<div class=\"col s12 m12\"><h4>You have not added any products yet.</h4></div>"+
    "</div>"
  );
  $('#orderConfirmed').remove();
  $('#buttonContainer').html("<button class=\"disabled waves-effect waves-light btn-large green darken-2\" type=\"button\">Add products first</button></div>");
}

function removeProduct(id){
  var element = JSON.parse(sessionStorage.getItem("cart"));
  element = element.filter(function(el) {
    return el.id !== id;
  });
  var jsonStr = JSON.stringify( element );
  sessionStorage.setItem("cart", jsonStr);
  location.reload();
}

$('#orderConfirmed').click(function(event){
  if(sessionStorage.getItem("role") != "null"){
    sessionStorage.setItem("performingOrder", true);
    window.location.replace("https://iacgroep3.herokuapp.com/Registration.html");
  }
  else{
    window.location.replace("https://iacgroep3.herokuapp.com/OrderConfirment.html");
  }
});
