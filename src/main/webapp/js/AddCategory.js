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
            .done(function(data) {
                        $.each(data, function (i, data) {
                            $('#select').append(new Option(this.name, this.id));
                            $('select').material_select();



                        });

});
});

function submitCategory(){
    event.preventDefault();
  var data = $("#AddCategoryForm").serialize();
   $.ajax({
             url: '../restservices/product/addcategory?product='+$("#id").val()+'&category='+$("#select").val(),
             type: 'PUT',
             data: data,

             beforeSend: function(xhr) {
                 var token = window.sessionStorage.getItem("sessionToken");
                 xhr.setRequestHeader('Authorization', 'Bearer ' + token);
             }
         })
         .done(function() {
             console.log("category added");
             alert("category added");
         })
         .fail(function() {
             console.log("failed");
             alert("failed");
         })
         .always(function() {
            Materialize.toast('', 4000);
         });
}
