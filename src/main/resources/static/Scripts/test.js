//Register.html request of register form (name,surname,email,password,repeat_password)

var send_register_data = function () {
    var infoForRegister = {
        name: $("#name_register").val(),
        surname: $("#surname_register").val(),
        email: $("#email_register").val(),
        password: $('#password_register').val()
    }
        console.log(getInfoFromInputRegisterHTML());
        $.ajax({
            type: 'PUT',
            url:  '/register',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(infoForRegister),
            dataType: 'json',
            async: true,
            success: function (data, textStatus, xhr) {
                //document.location.href = "/project/bMinded/account.html";
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("sdjkfhgsdf");
            }
        });
 
}


