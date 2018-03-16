$("#navbar").html(
  "<nav class=\"nav-extended\">"+
    "<div class=\"nav-wrapper grey lighten-1\">"+
      "<a href=\"index.html\" class=\"brand-logo\">Logo</a>"+
      "<a href=\"#\" data-activates=\"mobile-demo\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>"+
      "<ul class=\"right hide-on-med-and-down\">"+
        "<li><a href=\"Categorie.html\">Categorie�n</a></li>"+
        "<li><a href=\"Contact.html\">Contact</a></li>"+
        "<li><a href=\"ProductSearch.html\">All products</a></li>"+
        "<li><a href=\"ShoppingCard.html\">ShoppingCard</a></li>"+
        "<li><a href=\"Afmelden.html\">Afmelden</a></li>"+
      "</ul>"+
      "<div class=\"nav-content\">"+
        "<ul class=\"tabs tabs-transparent\" id=\"navContent\">"+
        var uri = "https://iacgroep3.herokuapp.com/restservices/categories/main";
         $.ajax(uri, {
                type: "GET",
                beforeSend: function(xhr){
                  var token = window.sessionStorage.getItem("sessionToken");
                  xhr.setRequestHeader('Authorization', 'Bearer ' + token);
                },
                success: function(response) {
                    $.each(response, function(key, value){
                        "<li class=\"tab\"><a href=\"https://iacgroep3.herokuapp.com/SubCategories.html\?id="+ value.id +"\">"+ value.name +"</a></li>"+
                    });
                },
                error: function(response) {
                    $("#errorHandling").html("The server could not get the main categories to display. Try logging in again or try again later.");
                }
            });
        "</ul>"+
      "</div>"+
    "</div>"+
  "</nav>"
);

//Categorieinfo();

$("#mobileNavbar").html(
  "<ul class=\"side-nav\" id=\"mobile-demo\">"+
    "<li><a href=\"Categorie.html\">Categorie�n</a></li>"+
    "<li><a href=\"Contact.html\">Contact</a></li>"+
    "<li><a href=\"ProductSearch.html\">All products</a></li>"+
    "<li><a href=\"ShoppingCard.html\">ShoppingCard</a></li>"+
    "<li><a href=\"Afmelden.html\">Afmelden</a></li>"+
  "</ul>"
);

function Categorieinfo(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/categories/main";
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
	            $.each(response, function(key, value){
	            	$("#navContent").append(
                  "<li class=\"tab\"><a href=\"https://iacgroep3.herokuapp.com/SubCategories.html\?id="+ value.id +"\">"+ value.name +"</a></li>"
                );
	            });
	        },
	        error: function(response) {
	            $("#errorHandling").html("The server could not get the main categories to display. Try logging in again or try again later.");
	        }
	    });
}
