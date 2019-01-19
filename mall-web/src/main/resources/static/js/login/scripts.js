jQuery(document).ready(function () {

    // $('#test').click(function () {
    //     var username = $("#username").val();
    //     var password = $("#password").val();
    //     alert(username + "--" + password);
    //
    //     $.ajax({
    //         type: "GET",
    //         url: "http://localhost:8084/test",
    //         // url: "http://localhost:8084/threadTest",
    //         dataType: "json",
    //         data: {
    //             name: username,
    //             password: password
    //         },
    //         success: function (data) {
    //             alert(data.toString());
    //
    //         }
    //     });
    // });

    $('.page-container form').submit(function () {
        var userId = $("#userId").val();
        var password = $("#userPwd").val();
        alert(userId + "--" + password);
        if (userId == '') {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.username').focus();
            });
            return false;
        } else if (password == '') {
            $(this).find('.error').fadeOut('fast', function () {
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function () {
                $(this).parent().find('.password').focus();
            });
            return false;
        } else {
            $.ajax({
                type: "POST",
                // processData: false,
                // async: true,//是否异步
                contentType: "application/json",
                url: "http://localhost:8080/login",
                // data: JSON.stringify({
                //         userId: userId,
                //         userPwd: password
                // }),
                success: function (data) {
                    alert(data.toString());
                    if ("0" == data.msgCode) {
                        //窗体重新加载
                        alert("success:" + data.toString());
                    } else {
                        alert("error:" + data.toString());
                    }
                },
                error: function (xhr, errorText, errorType) {
                    alert("xhr:" + xhr + "errorText:" + errorText + "errorType:" + errorType);
                }
            });
            return true;
        }
    });

    $('.page-container form .username, .page-container form .password').keyup(function () {
        $(this).parent().find('.error').fadeOut('fast');
    });

});