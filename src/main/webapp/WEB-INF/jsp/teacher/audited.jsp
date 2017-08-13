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
                <h4>已审核学生</h4>
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
<%@include file="../common/teacIncludeBottom.jsp" %>
