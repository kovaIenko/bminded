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
            url:  '/',
            contentType: 'application/json',
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

function  my()
{
    console.log("gkfjdk");
}




