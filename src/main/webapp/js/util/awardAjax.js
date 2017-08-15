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
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <a href='#' class='name'>" + content + "</a> </td> <td class='description'>" + date + "</td><td class='description'>" + degree + "</td><td class='description'>" + level + "</td><td class='description'>" + rank + "</td> <td> <ul class='actions'> <li><a class='myEdit btn btn-info' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete btn btn-danger' href='#'>删除</a></li> </ul> </td> </tr>")
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