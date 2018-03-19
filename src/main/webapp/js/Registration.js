$('.button-collapse').sideNav({
    menuWidth: 300,
    edge: 'left',
    closeOnClick: true,
    draggable: true
});

$("input, textarea").alphanum({
    allow              : '!@#$%&*(){}|:.,<>~+=_-?/',
    disallow           : '',
    allowSpace         : true,
    allowNumeric       : true,
    allowUpper         : true,
    allowLower         : true,
    allowCaseless      : true,
    allowLatin         : true,
    allowOtherCharSets : true,
    forceUpper         : false,
    forceLower         : false,
    maxLength          : NaN
});

$("#registerForm").validate({
       rules: {
           name:{
               required: true,
               maxlength: 60
           },
           email:{
               required:true,
               email :true,
               maxlength:80
           },
           password: {
               required: true,
               minlength: 8,
               maxlength: 50
           },
           passwordConfirm:{
               required:true,
               equalTo: "#password"
           },
           country:{
               required: true,
               maxlength: 60
           },
           city:{
               required: true,
               maxlength: 60
           },
           postalcode:{
               required: true,
               maxlength: 6
           },
           street:{
               required: true,
               maxlength: 60
           },
           housenumber:{
               required: true,
               maxlength: 10
           }
       },

       messages: {
           name:{
               required: "Enter your full name.",
               maxlength: "Your full name cant be this long."
           },
           email:{
               required: "Enter your email.",
               maxlength: "You can not enter a email with a length bigger then 80 signs."
           },
           password:{
               required: "Enter a strong password.",
               minlength: "A password must be atleast 8 long",
               maxlength: "Your password is to long. we dont need that much security."
           },
           passwordConfirm:{
               required: "Please validate your password.",
               equalTo: "Passwords do not equal eachother. please type them again.",
           },
           country:{
               required: "Please enter the country you live in.",
               maxlength: "Country names cant be that long."
           },
           city:{
               required: "Please enter your city name.",
               maxlength: "City names cant be that long."
           },
           postalcode:{
               required: "Please enter your postalcode.",
               maxlength: "type the postal code like this: 1234AB."
           },
           street:{
               required: "Please enter your street name.",
               maxlength: "your street name cant be that long."
           },
           housenumber:{
               required: "please enter your housenumber.",
               maxlength: "Your housenumber can not be that long."
           }
       },
       errorElement : 'div',
       errorPlacement: function(error, element) {
         var placement = $(element).data('error');
         if (placement) {
           $(placement).append(error);
         } else {
           error.insertAfter(element);
         }
     },
     /*submitHandler: function(form) {
       var uri = "restservices/Lid/Insert";
      $.ajax(uri, {
          type: "POST",
          data: $("#LidForum").serialize(),
          beforeSend: function(xhr){
          var token = window.sessionStorage.getItem("sessionToken");
          xhr.setRequestHeader('Authorization', 'Bearer ' + token);
          },
          success: function(response) {
             setTimeout(function() {
                  console.log("reloading");
                  location.reload();
                },1000)
              $("#response").text("Something Inserted!");
          },
          error: function(response) {
              $("#response").text("RIP!");
          }
      });

       event.preventDefault();
    }*/
    });

$('#postalcode').formatter({
      'pattern': '{{9999aa}}',
});

$(document).ready(function(){
    $('.tooltipped').tooltip({delay: 50});
  });
