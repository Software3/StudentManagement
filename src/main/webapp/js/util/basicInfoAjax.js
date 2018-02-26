function updateBasicInfo() {
    var studentId = $("#studentId").val();
    var name = $("#name").val();
    var sex = $("#sex").val();
    var birthday = $("#birthday").val();
    var nativePlace = $("#nativePlace").val();
    var residence = $("#residence").val();
    var major = $("#major").val();
    var employmentUnit = $("#employmentUnit").val();
    var counselorName = $("#counselorName").val();
    var counselorPhone = $("#counselorPhone").val();
    var studentType = getStudentType($("#studentType").val());
    var remarks = $("#remarks").val();
    json = {
        studentId: studentId,
        name: name,
        sex: sex,
        birthday: birthday,
        nativePlace: nativePlace,
        residence: residence,
        major: major,
        employmentUnit: employmentUnit,
        counselorName: counselorName,
        counselorPhone: counselorPhone,
        studentType: studentType,
        remarks: remarks
    };
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'upBasicInfo',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            $("#myAlert").append(alert("success", "修改成功！"));
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "修改失败！请稍后重试"))
        }
    });
}

function submitVerify(node){
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'submitVerify',
        dataType: 'text',
        method: 'GET',
        success: function (data) {
            $("#myAlert").append(alert("success", "提交成功！"));
            $(node).attr("disabled", "disabled");
            $("#confirmModify").attr("disabled", "disabled");
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "提交失败！请稍后重试"))
        }
    });
}

function updatePhoto() {
    $.ajaxFileUpload({
        url: 'uploadIdPhoto',
        secureuri: false,
        fileElementId: 'idPhoto',
        dataType: 'json',
        success: function (data, status) {
            var photoSrc = data.object;
            $("#myAlert").append(alert("success", "证件照上传成功！"));
            $("#idPhotoImg").attr("src", photoSrc);
        },
        error: function (data, status, e) {
            $("#myAlert").append(alert("success", "证件照上传失败！"));
        }
    })
}