function submitProduct(){
    event.preventDefault();
  var data = $("#AddProductForm").serialize();
   $.ajax({
             url: '../restservices/product/add',
             type: 'POST',
             data: data,

             beforeSend: function(xhr) {
                 var token = window.sessionStorage.getItem("sessionToken");
                 xhr.setRequestHeader('Authorization', 'Bearer ' + token);
             }
         })
         .done(function() {
             console.log("Product added");
         })
         .fail(function() {
             console.log("failed");
         })
         .always(function() {
            Materialize.toast('', 4000);
         });
}
