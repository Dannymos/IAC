$("#getcategoriesforproduct").click( (e)=> {
    e.preventDefault();

    let product = $("#id").val();

    $.ajax({
        url: '../restservices/categories/product/' + product,
        type: 'GET',


        beforeSend: function (xhr) {
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader('Authorization', 'Bearer ' + token);
        }
    })
         .done(function (data) {
            console.log(data);
            $('#categories').empty();
            for (let i = 0; i < data.length;i++) {
                console.log(i);

                $('#categories').append(
                    "<li class=\"collection-item\"><div>" + data[i].name + "<input class=\" removebutton btn \" value=\""+data[i].id+"\"href=\"#!\">delete me</input></div></li>"
                );

            }


        })
                .fail(function () {
                    console.log("failed");
                })
                .always(function () {

                });


        });
$(document).ready( ()=>{

    $(".removebutton").click( () =>{
        event.preventDefault();
       let  data = $(this).val();
        console.log(data);

        $.ajax({
             url: '../restservices/product/deletecategory?product='+$("#id").val()+'&category='+data,
            type: 'PUT',


            beforeSend: function(xhr) {
                var token = window.sessionStorage.getItem("sessionToken");
                xhr.setRequestHeader('Authorization', 'Bearer ' + token);
            }
        })
            .done(function() {
                console.log("Category deleted");
            })
            .fail(function() {
                console.log("failed");
            })
            .always(function() {

            });


    });
});
