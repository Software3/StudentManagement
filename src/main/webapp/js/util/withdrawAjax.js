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
                $("tbody").append("<tr class='first'> <td> <input type='checkbox' id='inst_" + instList[i].instId + "'> <div><img src='" + instList[i].description + "' class='img-responsive' /></div> </td> <td class='description'>" + instList[i].comment + "</td> <td> <ul class='actions'> <li><a class='viewPic' onclick='viewPic(this)' data-toggle='modal' href='#viewModal'>查看图片</a></li><li><a class='myEdit btn btn-info' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete btn btn-danger' href='#'>删除</a></li> </ul> </td> </tr>");
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

function viewInstPic(node, values) {
    $("#viewModal").empty();
    $("#viewModal").append(model("查看图片", 1, getModelForm(8), function () {
        $('#viewModal').modal('hide');
    }, values)[0]);
}