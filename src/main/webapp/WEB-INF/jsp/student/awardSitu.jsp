<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/9
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/includeTop.jsp" %>
<div id="pad-wrapper">

    <!-- products table-->
    <!-- the script for the toggle all checkboxes from header is located in js/theme.js -->
    <div class="table-wrapper products-table section">
        <div class="row head">
            <div class="col-md-12">
                <h4>获奖情况</h4>
            </div>
        </div>

        <div class="row filter-block">
            <div class="pull-right">
                <a class="btn-flat success new-product" data-toggle="modal" href="#addModal">添加获奖记录</a>
            </div>
        </div>

        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-3">
                        <input type="checkbox">
                        获奖名称
                    </th>
                    <th class="col-md-3">
                        <span class="line"></span>获奖时间
                    </th>
                    <th class="col-md-3">
                        <span class="line">操作</span>
                    </th>
                </tr>
                </thead>
                <tbody>
                <!-- row -->
                <c:forEach var="award" items="${awardList}">
                    <tr class="first">
                        <td>
                            <input type="checkbox">
                            <a href="#" class="name"><c:out value="${award.content}"/> </a>
                        </td>
                        <td class="description">
                            <c:out value="${award.date}"/>
                        </td>
                        <td>
                            <ul class="actions">
                                <li><a class="myEdit" onclick="editRow(this)" data-toggle="modal" href="#editModal">编辑</a></li>
                                <li class="last"><a onclick="deleteRow(this)" class="myDelete" href="#">删除</a></li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- end products table -->
</div>
</div>
<!-- end main container -->
<!-- modal start-->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true"></div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true"></div>
<!-- modal end-->
<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/tables.css" type="text/css" media="screen" />
<!-- scripts -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/widge/model.js"></script>
<script src="js/widge/alert.js"></script>
<script src="js/util/util.js"></script>

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {
        // init modal
        $("#addModal").append(model("添加获奖记录", 2, getModelForm(2), function () {})[0]);

        // add new member
        $("#confirmAdd").click(function () {
            // 成功后隐藏模态框,弹出提示框，并且刷新界面
            var content = $("#awardContent")[0].value;
            var date = $("#awardDate")[0].value;
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <div class='img'> <img src='img/table-img.png'> </div> <a href='#' class='name'>"+ content + "</a> </td> <td class='description'>" + date + "</td> <td> <ul class='actions'> <li><a class='myEdit' onclick='editRow(this)' data-toggle='modal' href='#editModal'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='myDelete' href='#'>删除</a></li> </ul> </td> </tr>")
        });
    });

    // delete member
    function deleteRow(node) {
        var index = $(".myDelete").index($(node));
        var rowTr = $("tbody")[0].rows[index];
        var content = rowTr.children[0].children[2].innerHTML;
        var date = trim(rowTr.children[1].innerHTML);
        $(rowTr).fadeTo("fast", 0.01, function () {
            $(rowTr).slideUp("fast", function () {
                $(rowTr).remove();
            })
        })
//        $("tbody")[0].removeChild(rowTr);
    }

    function editRow(node) {
        var values = getValues(node, "myEdit");
        $("#editModal").empty();
        $("#editModal").append(model("修改获奖记录", 2, getModelForm(3), function () {
            // 取值
            var content = $("#editContent")[0].value;
            var date = $("#editDate")[0].value;

            // 赋值
            var index = $(".myEdit").index($(node));
            var rowTr = $("tbody")[0].rows[index];
            rowTr.children[0].children[2].innerHTML = content;
            rowTr.children[1].innerHTML = date;

            // 隐藏modal，弹出alert
            $('#editModal').modal('hide');
            $("#myAlert").append(alert("success", "修改成功！"));
        }, values)[0]);
    }

    /**
     * 获取name, phone, relation的值
     * @param node
     * @param name
     * @returns {[*,*,*]}
     */
    function getValues(node, name) {
        var index = undefined;
        if (name == "myEdit") {
            index = $(".myEdit").index($(node));
        }else if (name == "myDelete") {
            index = $(".myDelete").index($(node));
        }
        var rowTr = $("tbody")[0].rows[index];
        var content = rowTr.children[0].children[2].innerHTML;
        var date = trim(rowTr.children[1].innerHTML);
        return [content, date];
    }
</script>
</body>
</html>