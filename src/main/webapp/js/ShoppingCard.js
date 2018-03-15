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
  }
}
else{
  //ERROR HANDLING FOR EMPTY SHOPPING CARD?
}
