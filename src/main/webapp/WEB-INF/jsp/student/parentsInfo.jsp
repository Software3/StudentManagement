<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/9
  Time: 13:12
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
                <h4>家庭成员信息</h4>
            </div>
        </div>

        <div class="row filter-block">
            <div class="pull-right">
                <a id="newNumber" class="btn-flat success new-product" data-toggle="modal" href="#addModal">添加新成员</a>
            </div>
        </div>

        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-2">
                        <input type="checkbox">
                        姓名
                    </th>
                    <th class="col-md-2">
                        <span class="line"></span>联系方式
                    </th>
                    <th class="col-md-2">
                        <span class="line"></span>与本人关系
                    </th>
                    <th class="col-md-3">
                        <span class="line"></span>操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <!-- row -->
                <tr class="first">
                    <td>
                        <input type="checkbox">
                        <div class="img">
                            <img src="img/table-img.png">
                        </div>
                        <a href="#" class="name">张三 </a>
                    </td>
                    <td class="description">
                        15616177562
                    </td>
                    <td>
                        <span class="label label-success">父亲</span>
                    </td>
                    <td>
                        <ul class="actions">
                            <li><a onclick="editRow(this)" href="#">编辑</a></li>
                            <li class="last"><a onclick="deleteRow(this)" class="delete" href="#">删除</a></li>
                        </ul>
                    </td>
                </tr>
                <!-- row -->
                <tr class="first">
                    <td>
                        <input type="checkbox">
                        <div class="img">
                            <img src="img/table-img.png">
                        </div>
                        <a href="#" class="name">李四 </a>
                    </td>
                    <td class="description">
                        15612567562
                    </td>
                    <td>
                        <span class="label label-success">母亲</span>
                    </td>
                    <td>
                        <ul class="actions">
                            <li><a onclick="editRow(this)" href="#">编辑</a></li>
                            <li class="last"><a onclick="deleteRow(this)" class="delete" href="#">删除</a></li>
                        </ul>
                    </td>
                </tr>
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
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
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
        $("#addModal").append(model()[0]);

        // add new member
        $("#confirmAdd").click(function () {
            // 成功后隐藏模态框,弹出提示框，并且刷新界面
            var name = $("#parentName")[0].value;
            var phone = $("#parentPhone")[0].value;
            var relation = $("#parentRelation")[0].value;
            $('#addModal').modal('hide');
            $("#myAlert").append(alert("success", "添加成功！"));
            $("tbody").append("<tr class='first'> <td> <input type='checkbox'> <div class='img'> <img src='img/table-img.png'> </div> <a href='#' class='name'>"+ name + "</a> </td> <td class='description'>" + phone + "</td> " +
                "<td> <span class='label label-success'>"+ relation + "</span> </td> <td> <ul class='actions'> <li><a onclick='editRow(this)' href='#'>编辑</a></li> <li class='last'><a onclick='deleteRow(this)' class='delete' href='#'>删除</a></li> </ul> </td> </tr>")
        });
    });

    // delete member
    function deleteRow(node) {
        var index = $(".delete").index($(node));
        var rowTr = $("tbody")[0].rows[index];
        var parentName = rowTr.children[0].children[2].innerHTML;
        var parentPhone = trim(rowTr.children[1].innerHTML);
        var parentRelation = rowTr.children[2].children[0].innerHTML;
        $(rowTr).fadeTo("fast", 0.01, function () {
            $(rowTr).slideUp("fast", function () {
                $(rowTr).remove();
            })
        })
//        $("tbody")[0].removeChild(rowTr);
    }

    function editRow(node) {
        var index = $(".delete").index($(node));
        var rowTr = $("tbody")[0].rows[index];
        var parentName = rowTr.children[0].children[2].innerHTML;
        var parentPhone = trim(rowTr.children[1].innerHTML);
        var parentRelation = rowTr.children[2].children[0].innerHTML;
    }

</script>
</body>
</html>