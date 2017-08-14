<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 51157
  Date: 2017/8/9
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/teacIncludeTop.jsp" %>
<div id="pad-wrapper">
    <div class="row filter-block">
        <div class="pull-left">
            <a class="btn-flat success" href="<%=request.getContextPath()%>/studentInformation">返回</a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-xs-12">
            <div id="fuelux-wizard" class="wizard row">
                <ul class="wizard-steps">
                    <li data-target="#step1" class="active">
                        <span class="step">1</span>
                        <span class="title">基本 <br> 信息</span>
                    </li>
                    <li data-target="#step2">
                        <span class="step">2</span>
                        <span class="title">家长 <br> 信息</span>
                    </li>
                    <li data-target="#step3">
                        <span class="step">3</span>
                        <span class="title">奖励 <br> 情况</span>
                    </li>
                    <li data-target="#step4">
                        <span class="step">4</span>
                        <span class="title">挂科 <br> 情况</span>
                    </li>
                    <li data-target="#step5">
                        <span class="step">5</span>
                        <span class="title">退队 <br> 说明</span>
                    </li>
                </ul>
            </div>
            <div class="step-content">
                <div class="step-pane active" id="step1">
                    <div class="row form-wrapper">
                        <div class="col-md-8">
                            <div class="field-box">
                                <label>学号:</label>
                                <input class="form-control" type="text" value="${student.studentId}"/>
                            </div>
                            <div class="field-box">
                                <label>姓名:</label>
                                <input class="form-control" type="text" value="${student.name}"/>
                            </div>
                            <div class="field-box">
                                <label>性别:</label>
                                <input class="form-control" type="text"
                                       value="<c:if test='${student.sex==0}'>女</c:if><c:if test='${student.sex==1}'>男</c:if>"/>
                            </div>
                            <div class="field-box">
                                <label>出生日期:</label>
                                <input class="form-control" type="text" value="${student.birthday}"/>
                            </div>
                            <div class="field-box">
                                <label>籍贯:</label>
                                <input class="form-control" type="text" value="${student.residence}"/>
                            </div>
                            <div class="field-box">
                                <label>家庭居住地:</label>
                                <input class="form-control" type="text" value="${student.nativePlace}"/>
                            </div>
                            <div class="field-box">
                                <label>专业:</label>
                                <input class="form-control" type="text" value="${student.major}"/>
                            </div>
                            <div class="field-box">
                                <label>就业单位:</label>
                                <input class="form-control" type="text" value="${student.employmentUnit}"/>
                            </div>
                            <div class="field-box">
                                <label>辅导员姓名:</label>
                                <input class="form-control" type="text" value="${student.counselorName}"/>
                            </div>
                            <div class="field-box">
                                <label>辅导员联系方式:</label>
                                <input class="form-control" type="text" value="${student.counselorPhone}"/>
                            </div>
                            <div class="field-box">
                                <label>学生类型:</label>
                                <input class="form-control" type="text"
                                       value="<c:if test="${student.studentType == 0}">本科生</c:if>
                            <c:if test="${student.studentType == 1}">研究生</c:if><c:if test="${student.studentType == 2}">高水平运动员</c:if>"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step2">
                    <div class="row form-wrapper">
                        <div class="col-md-12">
                            <div class="row">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th class="col-md-4">姓名
                                        </th>
                                        <th class="col-md-4">
                                            <span class="line"></span>联系方式
                                        </th>
                                        <th class="col-md-4">
                                            <span class="line"></span>与本人关系
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!-- row -->
                                    <c:forEach var="parent" items="${parents}">
                                        <tr class="first">
                                            <td>
                                                <a class="name"><c:out value="${parent.name}"/> </a>
                                            </td>
                                            <td class="description">
                                                <c:out value="${parent.phone}"/>
                                            </td>
                                            <td>
                                                <span class="label label-success"><c:if
                                                        test="${parent.relation == 0}">母亲</c:if> <c:if
                                                        test="${parent.relation == 1}">父亲</c:if> </span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <!-- row -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step3">
                    <div class="row form-wrapper">
                        <div class="col-md-12">
                            <div class="row">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th class="col-md-6">获奖名称
                                        </th>
                                        <th class="col-md-6">
                                            <span class="line"></span>获奖时间
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!-- row -->
                                    <c:forEach var="awardRecord" items="${awardRecords}">
                                        <tr class="first">
                                            <td>
                                                <a class="name"><c:out value="${awardRecord.content}"/> </a>
                                            </td>
                                            <td class="description">
                                                <c:out value="${awardRecord.date}"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step4">
                    <div class="row form-wrapper payment-info">
                        <div class="col-md-12">
                            <div class="row">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th class="col-md-6">学期
                                        </th>
                                        <th class="col-md-6">
                                            <span class="line"></span>科目
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!-- row -->
                                    <c:forEach var="failexamRecord" items="${failexamRecords}">
                                        <tr class="first">
                                            <td>
                                                <a class="name"><c:out value="${failexamRecord.term}"/> </a>
                                            </td>
                                            <td class="description">
                                                <c:out value="${failexamRecord.subject}"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="step-pane" id="step5">
                    <div class="row form-wrapper payment-info">
                        <div class="col-md-12">
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
                                                    <img src="${item.description}" class="img-responsive"/>
                                                </div>
                                            </td>
                                            <td class="description">
                                                    ${item.comment}
                                            </td>
                                            <td>
                                                <ul class="actions">
                                                    <li><a class="myEdit" onclick="editRow(this)" data-toggle="modal"
                                                           href="#editModal">编辑</a></li>
                                                    <li class="last"><a onclick="deleteRow(this)" class="myDelete"
                                                                        href="#">删除</a></li>
                                                </ul>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="wizard-actions">
                    <button type="button" disabled class="btn-glow primary btn-prev">
                        <i class="icon-chevron-left"></i> 上一级
                    </button>
                    <button type="button" class="btn-glow primary btn-next" data-last="Finish">
                        下一级 <i class="icon-chevron-right"></i>
                    </button>
                    <%--<button type="button" class="btn-glow success btn-finish">--%>
                        <%--确认修改--%>
                    <%--</button>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end main container -->

<link href="css/compiled/form-wizard.css" rel="stylesheet" media="screen"/>
<!-- scripts for this page -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/fuelux.wizard.js"></script>


<script type="text/javascript">
    $(function () {
        var $wizard = $('#fuelux-wizard'),
            $btnPrev = $('.wizard-actions .btn-prev'),
            $btnNext = $('.wizard-actions .btn-next'),
            $btnFinish = $(".wizard-actions .btn-finish");

        $wizard.wizard().on('finished', function (e) {
            // wizard complete code
        }).on("changed", function (e) {
            var step = $wizard.wizard("selectedItem");
            // reset states
            $btnNext.removeAttr("disabled");
            $btnPrev.removeAttr("disabled");
            $btnNext.show();
            $btnFinish.hide();

            if (step.step === 1) {
                $btnPrev.attr("disabled", "disabled");
            } else if (step.step === 5) {
                $btnNext.hide();
                $btnFinish.show();
            }
        });

        $btnPrev.on('click', function () {
            $wizard.wizard('previous');
        });
        $btnNext.on('click', function () {
            $wizard.wizard('next');
        });
    });

    function updateBasicInfo() {
        var studentId = $("#studentId").val();
        var name = $("#name").val();
        var sex = $("#sex").val();
        var birthday = $("#birthday").val();
        var nativePlace = $("#nativePlace").val();
        var residence = $("#residence").val();
        var major = $("#major").val();
        var employmentUnit = $("#employmentUnit").val();
        var counselorName = $("#counselorName").val();
        var counselorPhone = $("#counselorPhone").val();
        var studentType = getStudentType($("#studentType").val());
        var remarks = $("#remarks").val();
        json = {
            studentId: studentId,
            name: name,
            sex: sex,
            birthday: birthday,
            nativePlace: nativePlace,
            residence: residence,
            major: major,
            employmentUnit: employmentUnit,
            counselorName: counselorName,
            counselorPhone: counselorPhone,
            studentType: studentType,
            remarks: remarks
        };
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'upBasicInfo',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(json),
            success: function (data) {
                $("#myAlert").append(alert("success", "修改成功！"));
            },
            error: function (xhr) {
                $("#myAlert").append(alert("danger", "修改失败！请稍后重试"))
            }
        });
    }
</script>
<%@include file="../common/teacIncludeBottom.jsp" %>