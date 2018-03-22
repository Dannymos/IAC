$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

// $( document ).ready(function loadCategory(){
//   $.ajax({
//             url: "../restservices/categories/subcategories",
//             type: 'GET',
//             beforeSend: function(xhr) {
//                 var token = window.sessionStorage.getItem("sessionToken");
//                 xhr.setRequestHeader('Authorization', 'Bearer ' + token);
//             }
//           })
//
//
//
//             .done(function(result) {
//               $(result).each(function(index)){
//                   $("#select").append($("<option />").val(this.id).text(this.name));
//
//               });
//
// });
// }

$( document ).ready(function loadCategory(){
  $.ajax({
            url: "../restservices/categories/subcategories",
            type: 'GET',
            beforeSend: function(xhr) {
                var token = window.sessionStorage.getItem("sessionToken");
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }
            })
            .done(function(data) {
                        $(data).each(function(index) {
                            $("#select").append($("<option />").val(this.id).text(this.name));


                            Materialize.updateTextFields();

                        });

});
});



$(document).ready(function() {
    $('select').material_select();
  });
