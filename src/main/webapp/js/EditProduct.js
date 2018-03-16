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
             console.log("success");
         })
         .fail(function() {
             console.log("failed");
         })
         .always(function() {
            Materialize.toast('Information is changed', 4000);
         });
}
