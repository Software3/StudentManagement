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
    json = {studentId: studentId, name: name, sex: sex, birthday: birthday, nativePlace: nativePlace, residence: residence, major: major,
        employmentUnit: employmentUnit, counselorName: counselorName, counselorPhone: counselorPhone, studentType: studentType, remarks: remarks};
    console.log(studentId + " " + name + " " + sex + " " + birthday + " " + nativePlace + " " + residence + " " + major + " " + employmentUnit);
    console.log(counselorName + " " + counselorPhone + " " + studentType + " " + remarks);
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'upBasicInfo',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success")
            console.log(data);
            $("#myAlert").append(alert("success", "修改成功！"));
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "修改失败！请稍后重试"))
            console.log("failed")
            console.log(xhr);
        }
    });
}