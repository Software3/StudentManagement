<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/12
  Time: 20:43
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
                <h4>审核日志</h4>
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
                    <th class="col-md-2">
                        <span class="line"></span>
                        操作结果
                    </th>
                </tr>
                </thead>
                <tbody>
                <!-- row -->
                <tr class="first">
                    <td>
                        <a href="#" class="name">王五 </a>
                    </td>
                    <td class="description">
                        3903150328
                    </td>
                    <td>
                        <span class="label label-success">通过</span>
                    </td>
                </tr>
                <!-- row -->
                <tr class="first">
                    <td>
                        <a href="#" class="name">玄六 </a>
                    </td>
                    <td class="description">
                        3903150326
                    </td>
                    <td>
                        <span class="label label-danger">未通过</span>
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

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/tables.css" type="text/css" media="screen"/>
<!-- scripts -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
</body>
</html>
