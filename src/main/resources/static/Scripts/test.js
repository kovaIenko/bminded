//Register.html request of register form (name,surname,email,password,repeat_password)

var send_register_data = function () {

    var infoForRegister = {
        first_name: $("#name_register").val(),
        second_name: $("#surname_register").val(),
        email: $("#email_register").val(),
        password: $('#password_register').val(),
        confirmPasword: $('#repeat_password_register').val()
    }

        console.log(infoForRegister);

            $.ajax({
            type: 'POST',
            url:  '/register',
                contentType : 'application/json; charset=utf-8',
            data: JSON.stringify(infoForRegister),
            dataType: 'json',
            async: true,

            success: function (data, textStatus, xhr) {
                console.log("Success");
            },

            error: function (xhr, textStatus, errorThrown) {
                 console.log("Error");
            }
        });

}




