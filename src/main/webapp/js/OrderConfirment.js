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
  var uri = "https://iacgroep3.herokuapp.com/restservices/user/"+sessionStorage.getItem("id");
  let address;
  let name;
   $.ajax(uri, {
          type: "GET",
          beforeSend: function(xhr){
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader('Authorization', 'Bearer ' + token);
          },
          success: function(response) {

            console.log(response);
            var uri = "https://iacgroep3.herokuapp.com/restservices/order/complete?CustomerID="+sessionStorage.getItem("id")+"&deliveryAddress="+response.billing_address;
             $.ajax(uri, {
                    type: "POST",
                    beforeSend: function(xhr){
                      var token = window.sessionStorage.getItem("sessionToken");
                      xhr.setRequestHeader('Authorization', 'Bearer ' + token);
                    },
                    success: function(response) {
                        console.log(response);
                      if(element !== null){
                        if(element.length > 0){
                          var el;
                          for (el in element) {
                            var uri = "https://iacgroep3.herokuapp.com/restservices/order/"+response+"?product="+element[el].id+"&amount="+element[el].amount;
                             $.ajax(uri, {
                                    type: "POST",
                                    beforeSend: function(xhr){
                                      var token = window.sessionStorage.getItem("sessionToken");
                                      xhr.setRequestHeader('Authorization', 'Bearer ' + token);
                                    },
                                    success: function(response) {
                                      console.log("order added");
                                      //MOOIE MELDING ALS ALLES IS GOED GEGAAN EN WINDOW RELOCATE
                                    },
                                    error: function(response) {
                                      console.log("order failed");
                                      //MOOIE FOUTMELDING
                                    }
                                });
                          }
                        }
                      }
                      console.log("Order created");
                    },
                    error: function(response) {
                      $("#errorHandling").html("The server could not create a order. Please login again or try again at a later time.");
                    }
                });














          },
          error: function(response) {
            $("errorHandling").html("The server could not get your account information. Please try to log in again or try again at a later time.");
          }
      });
});

function soapy(orderid,name,deliveryaddress,price){

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open('POST', 'http://83.128.252.112:9999/java-ws/finishOrder?wsdl', true);

    var sr='<?xml version="1.0" encoding="utf-8"?>' +
        '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://service/">\n' +
        '   <soapenv:Header/>\n' +
        '   <soapenv:Body>\n' +
        '      <ser:say>\n' +
        '         <!--Optional:-->\n' +
        '         <name>'+name+'</name>\n' +
        '         <price>'+price+'</price>\n' +
        '         <!--Optional:-->\n' +
        '         <address>'+deliveryaddress+'</address>\n' +
        '         <order>'+orderid+'</order>\n' +
        '      </ser:say>\n' +
        '   </soapenv:Body>\n' +
        '</soapenv:Envelope>';

    xmlhttp.onreadystatechange = ()=>{
        if (xmlhttp.readyState==4){
            if(xmlhttp.status==200){
                console.log("succes");
            }
        }
    }
    xmlhttp.setRequestHeader('Content-Type','text/xml')
    xmlhttp.send(sr);

}