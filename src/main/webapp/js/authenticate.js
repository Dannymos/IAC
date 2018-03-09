@().click(function(event) {
    var email = $().value();
    var password = $().value();
    if(email != null && password != null) {
        $.ajax();
    } else {
        alert("Please enter a correct email & password");
    }
});