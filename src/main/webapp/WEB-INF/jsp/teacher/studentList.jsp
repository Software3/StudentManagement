<%--
  Created by IntelliJ IDEA.
  User: 51157
  Date: 2017/8/10
  Time: 22:43
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
                <h4>学生列表</h4>
            </div>
        </div>


        <div class="row">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="col-md-5">
                        姓名
                    </th>
                    <th class="col-md-5">
                        <span class="line"></span>
                        学号
                    </th>
                </tr>
                </thead>
                <tbody id="studentList">
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
    $(function () {
        $.ajax({
            url: 'getStudentList',
            dataType: 'json',
            method: 'GET',
            data: {teacherId: ${teacherId}},
            success: function (data) {
                var result = data.result;
                if (result = 'success') {
                    var studentList = data.object;
                    for (var i = 0; i < studentList.length; i++) {
                        $('#studentList').append("<tr class=\"first\">" +
                            "<td>" +
                            "<a >" + studentList[i].name + "</a>" +
                            "</td>" +
                            "<td class=\"description\">" +
                            studentList[i].studentId +
                            "</td>" +
                            "</tr>");
                    }
                }
                else {
                    alert("读取信息失败")
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
    });
</script>
<%@include file="../common/teacIncludeBottom.jsp" %>

