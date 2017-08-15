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