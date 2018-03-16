function loadGegevens(){
  $.ajax({
            url: "restservices/product/" + $("#id").val(),
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
