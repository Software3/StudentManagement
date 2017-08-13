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
                <a id="newMember" class="btn-flat success new-product" data-toggle="modal" href="#addModal">添加新成员</a>
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
                <c:forEach var="parent" items="${parentList}">
                    <tr class="first">
                        <td>
                            <input type="checkbox">
                            <a href="#" class="name"><c:out value="${parent.name}"/> </a>
                        </td>
                        <td class="description">
                            <c:out value="${parent.phone}"/>
                        </td>
                        <td>
                            <span class="label label-success"><c:if test="${parent.relation == 0}">母亲</c:if> <c:if test="${parent.relation == 1}">父亲</c:if></span>
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
<script src="js/widge/model.js"></script>
<script src="js/widge/alert.js"></script>
<script src="js/util/util.js"></script>
<script src="js/util/ajaxUtil.js"></script>

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {
        // init modal
        $("#addModal").append(model("添加新成员", 3, getModelForm(0), function () {})[0]);

        // add new member
        $("#confirmAdd").click(function () {
            addMember();
        });
    });

    // delete member
    function deleteRow(node) {
        delMember(node);
//        $("tbody")[0].removeChild(rowTr);
    }

    function editRow(node) {
        var values = getValues(node, "myEdit");
        upMember(node, values);
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
        var parentName = rowTr.children[0].children[1].innerHTML;
        var parentPhone = trim(rowTr.children[1].innerHTML);
        var parentRelation = rowTr.children[2].children[0].innerHTML;
        return [parentName, parentPhone, parentRelation];
    }

</script>
<%@include file="../common/includeBottom.jsp" %>