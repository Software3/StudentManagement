<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/12
  Time: 20:40
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
                <h4>高水平运动员入退队说明</h4>
            </div>
        </div>

        <div class="row filter-block">
            <div class="pull-right">
                <a class="btn-flat success new-product" data-toggle="modal" href="#addModal">添加入退队说明</a>
            </div>
        </div>

        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-3">
                        <input type="checkbox">
                        图片说明
                    </th>
                    <th class="col-md-3">
                        <span class="line"></span>文本说明
                    </th>
                    <th class="col-md-3">
                        <span class="line">操作</span>
                    </th>
                </tr>
                </thead>
                <tbody>
                <!-- row -->
                <c:forEach var="item" items="${withdrawInstList}">
                    <tr class="first">
                        <td>
                            <input type="checkbox" id="inst_${item.instId}">
                            <div>
                                <img src="${item.description}" class="img-responsive" />
                            </div>
                        </td>
                        <td class="description">
                            ${item.comment}
                        </td>
                        <td>
                            <ul class="actions">
                                <li><a class="viewPic" onclick="viewPic(this)" data-toggle="modal" href="#viewModal">查看图片</a></li>
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
<div class="modal fade" id="viewModal" tabindex="-1" role="dialog" aria-labelledby="viewModalLabel" aria-hidden="true"></div>
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true"></div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true"></div>
<!-- modal end-->
<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/tables.css" type="text/css" media="screen" />
<!-- scripts -->
<script src="js/widge/model.js"></script>
<script src="js/widge/alert.js"></script>
<script src="js/util/util.js"></script>
<script src="js/util/withdrawAjax.js"></script>
<script src="js/uploads/ajaxfileupload.js"></script>

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {
        // init modal
        $("#addModal").append(model("添加入退队说明", 2, getModelForm(6), function () {})[0]);

        // add new member
        $("#confirmAdd").click(function () {
            // 成功后隐藏模态框,弹出提示框，并且刷新界面
            addWithdrawInst();
        });
    });

    // delete member
    function deleteRow(node) {
        delWithdrawInst(node)
//        $("tbody")[0].removeChild(rowTr);
    }

    function editRow(node) {
        var values = getValues(node, "myEdit");
        upWithdrawInst(node, values);
    }

    function viewPic(node) {
        var values = getPicSrcAttr(node);
        viewInstPic(node, values);
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
        var comment = trim(rowTr.children[1].innerHTML)
        console.log(comment);
        return [undefined,comment];
    }

    /**
     * 获取图片url
     * @param node
     */
    function getPicSrcAttr(node) {
        var index = undefined;
        index = $(".viewPic").index($(node));
        var rowTr = $("tbody")[0].rows[index];
        var instPicUrl = rowTr.children[0].children[1].children[0].getAttribute("src");
        return [instPicUrl];
    }
</script>
<%@include file="../common/includeBottom.jsp" %>
