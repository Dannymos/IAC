function submitProduct(){
    event.preventDefault();
  var data = $("#submitform").serialize();
   $.ajax({
             url: '../restservices/product/'+$("#id").val(),
             type: 'PUT',
             data: data,

             beforeSend: function(xhr) {
                 var token = window.sessionStorage.getItem("sessionToken");
                 xhr.setRequestHeader('Authorization', 'Bearer ' + token);
             }
         })
         .done(function() {
             console.log("Information is changed");
         })
         .fail(function() {
             console.log("failed");
         })
         .always(function() {
            Materialize.toast('', 4000);
         });
}
