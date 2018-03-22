$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

$( document ).ready(function loadCategory(){
  $.ajax({
            url: "../restservices/categories/subcategories",
            type: 'GET',
            beforeSend: function(xhr) {
                var token = window.sessionStorage.getItem("sessionToken");
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }, success: function(result) {
              
              $.each(result, function() {
                  $("#select").append($("<option />").val(this.id).text(this.name));

              });
            }
});


});



$(document).ready(function() {
    $('select').material_select();
  });
