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
        url: '/register',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(infoForRegister),
        dataType: 'json',
        async: true,

        success: function (result) {
            window.location.replace("/");
        }
        ,
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });


    var send_new_name_data = function () {
        var  change_name_surname = {
            new_name: $("#new_name_account").val(),
            new_surname: $('#new_surname_account').val()
        }
        $.ajax({
            type: 'POST',
            url:  '/account',
            contentType : 'application/json; charset=utf-8',
            data: JSON.stringify(change_name_surname),
            async: true,

            success: function (data, textStatus, xhr) {
                console.log("Success");
            },

            error: function (xhr, textStatus, errorThrown) {
                console.log("Error");
            }
        });
    }

    var send_new_email_data = function () {
        var  change_email_data = {
            new_email: $("#new_email_account").val(),
        }
        $.ajax({
            type: 'POST',
            url:  '/account',
            contentType : 'application/json; charset=utf-8',
            data: JSON.stringify(change_email_data),
            async: true,

            success: function (data, textStatus, xhr) {
                console.log("Success" +  JSON.stringify(change_email_data));

            },

            error: function (xhr, textStatus, errorThrown) {
                console.log("Error");
            }
        });
    }
    var send_new_password_data = function () {
        var  change_password_data = {
            old_password: $("#old_password_account").val(),
            new_password: $("#new_password_account").val()
        }
        $.ajax({
            type: 'POST',
            url:  '/account',
            contentType : 'application/json; charset=utf-8',
            data: JSON.stringify(change_password_data),
            async: true,

            success: function (data, textStatus, xhr) {
                console.log("Success" + JSON.stringify(change_password_data));
            },

            error: function (xhr, textStatus, errorThrown) {
                console.log("Error");
            }
        });
    }

}




