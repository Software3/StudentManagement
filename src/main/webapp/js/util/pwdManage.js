function checkPassword() {
    var studentId=$('#studentId').val();
    var password=$('#old_password').val();
    var signon = {studentId: studentId, password: password};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'checkPassword',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(signon),
        success: function (data) {
           if(data.result=="success"){
               $('#newPasswordDiv').attr("style",'');
               $('#confirmPasswordDiv').attr("style",'');
               $('#confirmChangeDiv').attr("style",'');
           }else {
               $("#myAlert").append(alert("danger", "密码错误！"));
           }
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "修改失败！"));
        }
    })
}

function changeStuPassword() {
    var studentId=$('#studentId').val();
    var newPassword=$('#new_password').val();
    var confirmPassword=$('#confirm_password').val();
    if(newPassword!=confirmPassword){
        $("#myAlert").append(alert("danger", "两次密码不一致！"));
    }else if(newPassword==""&&confirmPassword==""){
        $("#myAlert").append(alert("danger", "密码不能为空！"));
    }else{
        var signon = {studentId: studentId, password: newPassword};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'changeStuPassword',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(signon),
            success: function (data) {
                if(data.result=="success"){
                    $("#myAlert").append(alert("success", "修改成功！"));
                }else {
                    $("#myAlert").append(alert("success", "修改失败！"));
                }
            },
            error: function (xhr) {
                $("#myAlert").append(alert("danger", "修改失败！"));
            }
        })
    }
}