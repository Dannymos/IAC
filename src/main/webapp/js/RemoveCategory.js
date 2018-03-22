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
                    "<li class=\"collection-item\"><div>" + data[i].name + "<a class=\" removebutton btn \" href=\"#!\">"+data[i].id+"</input></div></li>"
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

    $("#categories").on('click','a', () =>{

       let  data = $(this).text();
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
