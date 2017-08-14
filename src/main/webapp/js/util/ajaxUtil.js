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

function addMember() {
    // 成功后隐藏模态框,弹出提示框，并且刷新界面
    var name = $("#parentName").val();
    var phone = $("#parentPhone").val();
    var relation = $("#parentRelation").val() == '父亲' ? 1 : 0;
    var studentId = getStudentId();
    var json = {name: name, phone: phone, relation: relation, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addMember',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>" + name + "</a> </td> <td class='description'>" + phone + "</td> " +
                "<td> <span class='label label-success'>" + $("#parentRelation").val() + "</span> </td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>")
        },
        error: function (xhr) {
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
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
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
        var json = {name: name, phone: phone, relation: relation, studentId: studentId};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upMember',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
                // 赋值
                var index = $(".myEdit").index($(node));
                var rowTr = $("tbody")[0].rows[index];
                rowTr.children[0].children[1].innerHTML = name;
                rowTr.children[1].innerHTML = phone;
                rowTr.children[2].children[0].innerHTML = $("#editRelation").val();

                // 隐藏modal，弹出alert
                $('#editModal').modal('hide');
                $("#myAlert").append(alert("success", "修改成功！"));
            },
            error: function (xhr) {
                $("#myAlert").append(alert("danger", "修改失败！"));
            }
        })
    }, values)[0]);
}

function addAward() {
    var content = $("#awardContent").val();
    var date = $("#awardDate").val();
    var degree = $("#awardDegree").val();
    var level = $("#awardLevel").val();
    var rank = $("#awardRank").val();
    var studentId = getStudentId();
    var json = {content: content, date: date, studentId: studentId, degree: degree, level: level, rank: rank};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addAward',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>" + content + "</a> </td> <td class='description'>" + date + "</td><td class='description'>" + degree + "</td><td class='description'>" + level + "</td><td class='description'>" + rank + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>")
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "添加失败！"));
        }
    })
}

function delAward(node) {
    var index = $(".myDelete").index($(node));
    var rowTr = $("tbody")[0].rows[index];
    var content = rowTr.children[0].children[1].innerHTML;
    var date = trim(rowTr.children[1].innerHTML);
    var degree = trim(rowTr.children[2].innerHTML);
    var level = trim(rowTr.children[3].innerHTML);
    var rank = trim(rowTr.children[4].innerHTML);
    var studentId = getStudentId();
    var json = {content: content, date: date, studentId: studentId, degree: degree, level: level, rank: rank};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'delAward',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "删除失败！"));
        }
    })
}

function upAward(node, values) {
    $("#editModal").empty();
    $("#editModal").append(model("修改获奖记录", 5, getModelForm(3), function () {
        // 取值
        var content = $("#editContent").val();
        var date = $("#editDate").val();
        var degree = $("#editDegree").val();
        var level = $("#editLevel").val();
        var rank = $("#editRank").val();
        var studentId = getStudentId();
        var json = {content: content, date: date, studentId: studentId, degree: degree, level: level, rank: rank};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upAward',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
                // 赋值
                var index = $(".myEdit").index($(node));
                var rowTr = $("tbody")[0].rows[index];
                rowTr.children[0].children[1].innerHTML = content;
                rowTr.children[1].innerHTML = date;
                rowTr.children[2].innerHTML = degree;
                rowTr.children[3].innerHTML = level;
                rowTr.children[4].innerHTML = rank;

                // 隐藏modal，弹出alert
                $('#editModal').modal('hide');
                $("#myAlert").append(alert("success", "修改成功！"));
            },
            error: function (xhr) {
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
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>" + term + "</a> </td> <td class='description'>" + subject + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>");
        },
        error: function (xhr) {
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
    var json = {term: term, subject: subject, studentId: studentId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'delFailed',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
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
        var json = {term: term, subject: subject, studentId: studentId};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upFailed',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
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
                $("#myAlert").append(alert("danger", "修改失败！"));
            }
        })
    }, values)[0]);
}

function addWithdrawInst() {
    var comment = $("#instComment").val();
    var json = {comment: comment};
    $.ajaxFileUpload({
        url: 'addWithdrawInst',
        secureuri: false,
        data: json,
        fileElementId: 'instPicture',
        dataType: 'json',
        success: function (data, status) {
            var instList = data.object;
            $('#addModal').modal('hide');
            $("tbody").empty();
            for (var i = 0;i < instList.length;i++) {
                $("tbody").append("<tr class='first'> <td> <input type='checkbox' id='inst_" + instList[i].instId + "'> <div><img src='" + instList[i].description + "' class='img-responsive' /></div> </td> <td class='description'>" + instList[i].comment + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>");
            }
            $("#myAlert").append(alert("success", "添加成功！"));

        },
        error: function (data, status, e) {
            $("#myAlert").append(alert("success", "添加失败！"));
        }
    })
}

function delWithdrawInst(node) {
    var index = $(".myDelete").index($(node));
    var rowTr = $("tbody")[0].rows[index];
    var instId = rowTr.children[0].children[0].id.split('_')[1];
    var json = {instId: instId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'delWithdrawInst',
        dataType: 'json',
        method: 'POST',
        data: JSON.stringify(json),
        success: function (data) {
            $(rowTr).fadeTo("fast", 0.01, function () {
                $(rowTr).slideUp("fast", function () {
                    $(rowTr).remove();
                })
            })
            $("#myAlert").append(alert("success", "删除成功！"));
        },
        error: function (xhr) {
            $("#myAlert").append(alert("danger", "删除失败！"));
        }
    })
}

function upWithdrawInst(node, values) {
    $("#editModal").empty();
    $("#editModal").append(model("修改入退队说明", 2, getModelForm(7), function () {
        // 取值
        var index = $(".myEdit").index($(node));
        var rowTr = $("tbody")[0].rows[index];
        var instId = rowTr.children[0].children[0].id.split('_')[1];
        var comment = $("#editComment").val();
        var json = {instId: instId, comment: comment};
        $.ajaxFileUpload({
            url: 'upWithdrawInst',
            secureuri: false,
            data: json,
            fileElementId: 'editPicture',
            dataType: 'json',
            success: function (data, status) {
                var instList = data.object;
                $('#editModal').modal('hide');
                $("tbody").empty();
                for (var i = 0;i < instList.length;i++) {
                    $("tbody").append("<tr class='first'> <td> <input type='checkbox' id='inst_" + instList[i].instId + "'> <div><img src='" + instList[i].description + "' class='img-responsive' /></div> </td> <td class='description'>" + instList[i].comment + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>");
                }
                $("#myAlert").append(alert("success", "添加成功！"));

            },
            error: function (data, status, e) {
                $("#myAlert").append(alert("success", "修改失败！"));
            }
        })
    }, values)[0]);
}

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