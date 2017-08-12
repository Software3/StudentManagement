var studentId = 3903150326;

function getStudentId() {
    return studentId;
}

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

function addMember() {
    // 成功后隐藏模态框,弹出提示框，并且刷新界面
    var name = $("#parentName").val();
    var phone = $("#parentPhone").val();
    var relation = $("#parentRelation").val() == '父亲' ? 1 : 0;
    var studentId = getStudentId();
    var json = {name: name, phone: phone, relation: relation, studentId: studentId};
    console.log(json);
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addMember',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success");
            console.log(data);
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>"+ name + "</a> </td> <td class='description'>" + phone + "</td> " +
                "<td> <span class='label label-success'>"+ relation + "</span> </td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>")
        },
        error: function (xhr) {
            console.log("failed");
            console.log(xhr);
            $("#myAlert").append(alert("danger", "添加失败！"));
        }
    })
}

function delMember(node) {
    var index = $(".myDelete").index($(node));
    var rowTr = $("tbody")[0].rows[index];
    var parentName = rowTr.children[0].children[1].innerHTML;
    var parentPhone = trim(rowTr.children[1].innerHTML);
    var parentRelation = rowTr.children[2].children[0].innerHTML;
    var studentId = getStudentId();
    var json = {name: parentName, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'delMember',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success");
            console.log(data);
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
            console.log("failed");
            console.log(xhr);
            $("#myAlert").append(alert("danger", "删除失败！"));
        }
    })
}

function upMember(node, values) {
    $("#editModal").empty();
    $("#editModal").append(model("修改成员信息", 3, getModelForm(1), function () {
        // 取值
        var name = $("#editName").val();
        var phone = $("#editPhone").val();
        var relation = $("#editRelation").val() == '父亲' ? 1 : 0;
        var studentId = getStudentId();
        var json = {name: name, phone: phone, relation:relation, studentId: studentId};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upMember',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
                console.log("success");
                console.log(data);
                // 赋值
                var index = $(".myEdit").index($(node));
                var rowTr = $("tbody")[0].rows[index];
                rowTr.children[0].children[1].innerHTML = name;
                rowTr.children[1].innerHTML = phone;
                rowTr.children[2].children[0].innerHTML = relation;

                // 隐藏modal，弹出alert
                $('#editModal').modal('hide');
                $("#myAlert").append(alert("success", "修改成功！"));
            },
            error: function (xhr) {
                console.log("failed");
                console.log(xhr);
                $("#myAlert").append(alert("danger", "修改失败！"));
            }
        })
    }, values)[0]);
}

function addAward() {
    var content = $("#awardContent").val();
    var date = $("#awardDate").val();
    var studentId = getStudentId();
    var json = {content: content, date: date, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addAward',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success");
            console.log(data);
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>"+ content + "</a> </td> <td class='description'>" + date + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>")
        },
        error: function (xhr) {
            console.log("failed");
            console.log(xhr);
            $("#myAlert").append(alert("danger", "添加失败！"));
        }
    })
}

function delAward(node) {
    var index = $(".myDelete").index($(node));
    var rowTr = $("tbody")[0].rows[index];
    var content = rowTr.children[0].children[1].innerHTML;
    var date = trim(rowTr.children[1].innerHTML);
    var studentId = getStudentId();
    var json = {content: content, date: date, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'delMember',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success");
            console.log(data);
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
            console.log("failed");
            console.log(xhr);
            $("#myAlert").append(alert("danger", "删除失败！"));
        }
    })
}

function upAward(node, values) {
    $("#editModal").empty();
    $("#editModal").append(model("修改获奖记录", 2, getModelForm(3), function () {
        // 取值
        var content = $("#editContent").val();
        var date = $("#editDate").val();
        var studentId = getStudentId();
        var json = {content: content, date: date, studentId: studentId};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upAward',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
                console.log("success");
                console.log(data);
                // 赋值
                var index = $(".myEdit").index($(node));
                var rowTr = $("tbody")[0].rows[index];
                rowTr.children[0].children[1].innerHTML = content;
                rowTr.children[1].innerHTML = date;

                // 隐藏modal，弹出alert
                $('#editModal').modal('hide');
                $("#myAlert").append(alert("success", "修改成功！"));
            },
            error: function (xhr) {
                console.log("failed");
                console.log(xhr);
                $("#myAlert").append(alert("danger", "修改失败！"));
            }
        })
    }, values)[0]);
}

function addFailed() {
    var term = $("#failedTerm").val();
    var subject = $("#failedSubject").val();
    var studentId = getStudentId();
    var json = {term: term, subject: subject, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addFailed',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success");
            console.log(data);
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>"+ term + "</a> </td> <td class='description'>" + subject + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>");
        },
        error: function (xhr) {
            console.log("failed");
            console.log(xhr);
            $("#myAlert").append(alert("danger", "添加失败！"));
        }
    })
}

function delFailed(node) {
    var index = $(".myDelete").index($(node));
    var rowTr = $("tbody")[0].rows[index];
    var term = rowTr.children[0].children[1].innerHTML;
    var subject = trim(rowTr.children[1].innerHTML);
    var studentId = getStudentId();
    var json = {term: term, subject:subject, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'delFailed',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            console.log("success");
            console.log(data);
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
            console.log("failed");
            console.log(xhr);
            $("#myAlert").append(alert("danger", "删除失败！"));
        }
    })
}

function upFailed(node, values) {
    $("#editModal").empty();
    $("#editModal").append(model("修改挂科记录", 2, getModelForm(5), function () {
        // 取值
        var term = $("#editTerm")[0].value;
        var subject = $("#editSubject")[0].value;
        var studentId = getStudentId();
        var json = {term: term, subject:subject, studentId: studentId};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upAward',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
                console.log("success");
                console.log(data);
                // 赋值
                var index = $(".myEdit").index($(node));
                var rowTr = $("tbody")[0].rows[index];
                rowTr.children[0].children[1].innerHTML = term;
                rowTr.children[1].innerHTML = subject;

                // 隐藏modal，弹出alert
                $('#editModal').modal('hide');
                $("#myAlert").append(alert("success", "修改成功！"));
            },
            error: function (xhr) {
                console.log("failed");
                console.log(xhr);
                $("#myAlert").append(alert("danger", "修改失败！"));
            }
        })
    }, values)[0]);
}

