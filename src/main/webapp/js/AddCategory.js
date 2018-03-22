$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

function loadGegevens(){
  $.ajax({
            url: "../restservices/categories/subcategories",
            type: 'GET',
            beforeSend: function(xhr) {
                var token = window.sessionStorage.getItem("sessionToken");
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }
          });
            var $select = $("#select");
            $.each(result, function() {
                $select.append($("<option />").val(this.id).text(this.name));

            });


}



$(document).ready(function() {
    $('select').material_select();
  });
