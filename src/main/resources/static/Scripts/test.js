//--------------------------------------------------------------------------------------------

//Register.html request of register form (name,surname,email,password,repeat_password)
/*
var infoForRegister;
function getInfoFromInputRegisterHTML() {
    infoForRegister = {
        name: $("#name_register").val(),
        surname: $("#surname_register").val(),
        email: $("#email_register").val(),
        password: $('#password_register').val()
    }
    return JSON.stringify(infoForRegister);
}
$(document).ready(function () {
$('#button_register').click(function () {
	console.log("oOOOOOOOOOOOOOOOOOOO");
    if($('#password_register').val() == $('#repeat_password_register').val() && $('#password_register').val() != ''
    && $('#name_register').val() != '' && $('#surname_register').val() != '' && checkEmail() == true) {
        console.log(getInfoFromInputRegisterHTML());
        $.ajax({
            type: 'POST',
            url: '/signup',
            data: getInfoFromInputRegisterHTML(),
            success: function (data, textStatus, xhr) {
            	console.log("sjhdsfsjdkfh");
               document.location.href = "/account";
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("sdjkfhgsdf");
            }
        });
    }else {alert("sdfsdf")}
});
});

function checkEmail() {
    var str = $('#email_register').val();
    for( var i = 1; i < str.length-1; i++)
    {
        if(str[i] == '@')
        {
            return true;
        }
    }
    return false;
}
*/