$("#getcategoriesforproduct").click( (e)=> {
    e.preventDefault();

    let product = $("#id").val();

    $.ajax({
        url: '../restservices/category/product/' + product,
        type: 'GET',


        beforeSend: function (xhr) {
            var token = window.sessionStorage.getItem("sessionToken");
            xhr.setRequestHeader('Authorization', 'Bearer ' + token);
        }
    })
        .done(function (data) {
            $(data).each(data, (index) => {
                $('#categories').append(
                    "<li class=\"collection-item\"><div>" + this.name + "<a data-category=\"" + this.id + "\" href=\"#!\">delete me</a></div></li>"
                );


            })
                .fail(function () {
                    console.log("failed");
                })
                .always(function () {

                });


        })
});