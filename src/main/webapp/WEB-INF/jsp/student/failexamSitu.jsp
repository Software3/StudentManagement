<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/9
  Time: 13:49
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
                <h4>挂科情况</h4>
            </div>
        </div>

        <div class="row filter-block">
            <div class="pull-right">
                <a class="btn-flat success new-product" data-toggle="modal" href="#addModal">添加挂科记录</a>
            </div>
        </div>

        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-3">
                        <input type="checkbox">
                        学期
                    </th>
                    <th class="col-md-3">
                        <span class="line"></span>科目
                    </th>
                    <th class="col-md-3">
                        <span class="line">操作</span>
                    </th>
                </tr>
                </thead>
                <tbody>
                <!-- row -->
                <c:forEach var="failed" items="${failedList}">
                    <tr class="first">
                        <td>
                            <input type="checkbox">
                            <a href="#" class="name"><c:out value="${failed.term}"/></a>
                        </td>
                        <td class="description">
                            <c:out value="${failed.subject}"/>
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
<script src="js/util/ajaxUtil.js"></script>

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {
        // init modal
        $("#addModal").append(model("添加挂科记录", 2, getModelForm(4), function () {})[0]);

        // add new member
        $("#confirmAdd").click(function () {
            // 成功后隐藏模态框,弹出提示框，并且刷新界面
            addFailed();
        });
    });

    // delete member
    function deleteRow(node) {
        delFailed(node)
//        $("tbody")[0].removeChild(rowTr);
    }

    function editRow(node) {
        var values = getValues(node, "myEdit");
        upFailed(node, values);
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
        console.log(rowTr.children[0])
        var term = rowTr.children[0].children[1].innerHTML;
        var subject = trim(rowTr.children[1].innerHTML);
        return [term, subject];
    }
</script>
</body>
</html>
