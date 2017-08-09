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
                <a class="btn-flat success new-product">添加挂科记录</a>
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
                <tr class="first">
                    <td>
                        <input type="checkbox">
                        <div class="img">
                            <img src="img/table-img.png">
                        </div>
                        <a href="#" class="name">2016-2017-2 </a>
                    </td>
                    <td class="description">
                        排球
                    </td>
                    <td>
                        <ul class="actions">
                            <li><a href="#">编辑</a></li>
                            <li class="last"><a href="#">删除</a></li>
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

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/tables.css" type="text/css" media="screen" />
<!-- scripts -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
</body>
</html>
