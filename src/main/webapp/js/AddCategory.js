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
            }
          })



            .success(function(result) {
              var $select = $("#select");
              $.each(result, function() {
                  $("#select").append($("<option />").val(this.id).text(this.name));

              });

});
});

function loadGegevens(){
  $.ajax({
            url: "../restservices/product/" + $("#id").val(),
            type: 'GET',
            beforeSend: function(xhr) {
                var token = window.sessionStorage.getItem("sessionToken");
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }
            })
            .done(function(data) {
                        $(data).each(function(index) {
                            $("#name").val(this.name);
                            $("#price").val(this.price);
                            $("#explanation").val(this.explanation);
                            $("#image").val(this.image);


                            Materialize.updateTextFields();

                        });

});
}



$(document).ready(function() {
    $('select').material_select();
  });
