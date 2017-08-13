<%--
  Created by IntelliJ IDEA.
  User: 51157
  Date: 2017/8/9
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/teacIncludeTop.jsp" %>
<div id="pad-wrapper">

    <!-- products table-->
    <!-- the script for the toggle all checkboxes from header is located in js/theme.js -->
    <div class="table-wrapper products-table section">
        <div class="row head">
            <div class="col-md-12">
                <h4>未审核学生</h4>
            </div>
        </div>


        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-5">
                        <input type="checkbox">
                        姓名
                    </th>
                    <th class="col-md-5">
                        <span class="line"></span>
                        学号
                    </th>
                    <th class="col-md-2">
                        <span class="line"></span>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <!-- row -->
                <c:forEach var="student" items="${students}">
                    <tr class="first">
                        <td>
                            <input type="checkbox">
                            <a href="#" class="name">${student.name} </a>
                        </td>
                        <td class="description">
                                ${student.studentId}
                        </td>
                        <td>
                            <ul class="actions">
                                <li>
                                    <a href="<%=request.getContextPath()%>/auditInformation?studentId=${student.studentId}&teacherId=${teacherId}">查看信息</a>
                                </li>
                                <li><a href="#" onclick="pass(this)">通过</a></li>
                                <li class="last"><a href="#" onclick="fail(this)">未通过</a></li>
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

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/tables.css" type="text/css" media="screen"/>
<!-- scripts -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
<script>
    function pass(obj) {
        var studentId = obj.parentNode.parentNode.parentNode.parentNode.childNodes[3].innerHTML;
        var studentName = obj.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[3].innerHTML;
        studentId = $.trim(studentId);
        var verify = {};
        verify.studentId = studentId;
        verify.studentName = studentName;
        verify.counselorName =${teacherId};
        verify.verifyOperate = 1;
        var date = new Date();
        verify.date = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'auditedPass',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(verify),
            success: function (data) {
                if (data.result == "success") {
                    //操作
                }
            },
            error: function (xhr) {
                // 导致出错的原因较多，以后再研究
                alert('error:' + JSON.stringify(xhr));
            }
        }).done(function (data) {
            // 请求成功后要做的工作
            console.log('success');
        }).fail(function () {
            // 请求失败后要做的工作
            console.log('error');
        }).always(function () {
            // 不管成功或失败都要做的工作
            console.log('complete');
        });
    }

    function fail(obj) {
        var studentId = obj.parentNode.parentNode.parentNode.parentNode.childNodes[3].innerHTML;
        var studentName = obj.parentNode.parentNode.parentNode.parentNode.childNodes[1].childNodes[3].innerHTML;
        studentId = $.trim(studentId);
        var verify = {};
        verify.studentId = studentId;
        verify.studentName = studentName;
        verify.counselorName =${teacherId};
        verify.verifyOperate = 0;
        var date = new Date();
        verify.date = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'auditedFail',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(verify),
            success: function (data) {
                if (data.result == "success") {
                    //操作
                }
            },
            error: function (xhr) {
                // 导致出错的原因较多，以后再研究
                alert('error:' + JSON.stringify(xhr));
            }
        }).done(function (data) {
            // 请求成功后要做的工作
            console.log('success');
        }).fail(function () {
            // 请求失败后要做的工作
            console.log('error');
        }).always(function () {
            // 不管成功或失败都要做的工作
            console.log('complete');
        });
    }
</script>
<%@include file="../common/teacIncludeBottom.jsp" %>
