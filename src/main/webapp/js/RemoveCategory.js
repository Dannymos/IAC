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
            $(data).each((index) => {
                console.log(this);
                $('#categories').empty();
                $('#categories').append(
                    "<li class=\"collection-item\"><div>" + data[index].name + "<a class=\" removebutton data-category=\"" + data[index].id + "\" href=\"#!\">delete me</a></div></li>"
                );


            })
        })
                .fail(function () {
                    console.log("failed");
                })
                .always(function () {

                });


        });

$(".removebutton").click( (e) =>{

        data = this.data()
    da



});