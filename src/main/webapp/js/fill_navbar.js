$("#navbar").html(
    "<div class=\"nav-wrapper grey lighten-1\" id=\"navContent1\">"+
      "<a href=\"Home.html\" class=\"brand-logo\">Logo</a>"+
      "<a href=\"#\" data-activates=\"mobile-demo\" class=\"button-collapse\"><i class=\"material-icons\">menu</i></a>"+
      "<ul class=\"right hide-on-med-and-down\" id=\"nav-mobile\">"+
        "<li><a href=\"Categorie.html\">Categories</a></li>"+
        "<li><a href=\"Contact.html\">Contact</a></li>"+
        "<li><a href=\"ProductSearch.html\">All products</a></li>"+
        "<li><a href=\"ShoppingCard.html\">ShoppingCard</a></li>"+
        "<li><a id=\"afmelden\" href=\"index.html\">Afmelden</a></li>"+
      "</ul>"+
      "<ul class=\"side-nav\" id=\"mobile-demo\">"+
        "<li><a href=\"Categorie.html\">Categorie�n</a></li>"+
        "<li><a href=\"Contact.html\">Contact</a></li>"+
        "<li><a href=\"ProductSearch.html\">All products</a></li>"+
        "<li><a href=\"ShoppingCard.html\">Shopping Cart</a></li>"+
        "<li><a href=\"Afmelden.html\">Afmelden</a></li>"+
      "</ul>"+
    "</div>"
);

Categorieinfo();

function Categorieinfo(){
	var uri = "https://iacgroep3.herokuapp.com/restservices/categories/main";
	 $.ajax(uri, {
	        type: "GET",
	        beforeSend: function(xhr){
	        	var token = window.sessionStorage.getItem("sessionToken");
	        	xhr.setRequestHeader('Authorization', 'Bearer ' + token);
	        },
	        success: function(response) {
            $("#navContent1").after(
              "<div class=\"nav-content grey lighten-1\">"+
                "<ul class=\"tabs tabs-transparent\" id=\"navContent2\">"
            );
	            $.each(response, function(key, value){
                if(response.length-1 == key){
	            	$("#navContent2").append(
                    "<li class=\"tab\"><a href=\"https://iacgroep3.herokuapp.com/SubCategories.html\?id="+ value.id +"\" id=\"navContent3\">"+ value.name +"</a></li>"
                  );
                  }
                  else{
                    $("#navContent2").append(
                    "<li class=\"tab\"><a href=\"https://iacgroep3.herokuapp.com/SubCategories.html\?id="+ value.id +"\">"+ value.name +"</a></li>");
                  }
	            });
              $("#navContent3").append(
                "</ul>"
              );
	        },
	        error: function(response) {
	            $("#errorHandling").html("The server could not get the main categories to display. Try logging in again or try again later.");
	        }
	    });
}

$('#afmelden').click(function(event){
  sessionStorage.removeItem("sessionToken");
  console.log("Afgemeld");
});
