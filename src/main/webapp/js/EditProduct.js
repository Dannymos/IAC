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

function submitGegevens(){
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

function verwijder(){
  event.preventDefault();
 $.ajax({
           url: '../restservices/product/'+$("#id").val(),
           type: 'DELETE',

           beforeSend: function(xhr) {
               var token = window.sessionStorage.getItem("sessionToken");
               xhr.setRequestHeader('Authorization', 'Bearer ' + token);
           }
       })
       .done(function() {
           console.log("Product Deleted");
       })
       .fail(function() {
           console.log("failed");
       })
       .always(function() {
          Materialize.toast('', 4000);
       });

}
