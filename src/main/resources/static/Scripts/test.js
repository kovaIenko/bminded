//Register.html request of register form (name,surname,email,password,repeat_password)

//Register.html request of register form (name,surname,email,password,repeat_password)
var send_register_data = function () {
    if (checkRegisterFormData() == true) {

        var infoForRegister = {
            'name': $("#name_register").val(),
            'surname': $("#surname_register").val(),
            'email': $("#email_register").val(),
            'password': $('#password_register').val()
        }
        console.log(infoForRegister);
        $.ajax({
            type: 'POST',
            url: 'register.html',
            data: JSON.stringify(infoForRegister),
            async: true,
            success: function (result) {
                alert('At ' + result.time
                    + ': ' + result.message);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var name = ("invalid email");
                var el = document.getElementById('invalid_email');
                if (typeof el.innerText !== 'undefined') {
                    // IE8-
                    el.innerText = name;
                } else {
                    // Нормальные браузеры
                    el.textContent = name;
                }
            }
        });
    }
}
function checkImage() {
    console.log($('#file').val().length);
    if ($('#file').val().length == '') {
        var name = ("incorrect image");
        var el = document.getElementById('incorrect_image');
        if (typeof el.innerText !== 'undefined') {
            // IE8-
            el.innerText = name;
        } else {
            // Нормальные браузеры
            el.textContent = name;
        }
        return false;
    }
    return true;
}

function checkRegisterFormData() {
    if ($("#password_register").val() == $("#repeat_password_register").val() && $("#password_register").val() != "" && $("#repeat_password_register").val() != ""
        && $("#name_register").val() != "" && $("#surname_register").val() != "" && $("#email_register").val() != "") {
        return true;
    } else {

        var name = ("mismatched passwords");
        var el = document.getElementById('mismatched_passwords');
        if (typeof el.innerText !== 'undefined') {
            // IE8-
            el.innerText = name;
        } else {
            // Нормальные браузеры
            el.textContent = name;
        }
        return false;
    }
    return false;
}


