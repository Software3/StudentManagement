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
            <a class="btn-flat success" href="<%=request.getContextPath()%>/audited?teacherId="${userid}>返回</a>
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
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.studentId}"/>
                            </div>
                            <div class=" field-box">
                                <label>姓名:</label>
                                <input class="form-control" type="text" readonly="readonly" value="${student.name}"/>
                            </div>
                            <div class="field-box">
                                <label>性别:</label>
                                <input class="form-control" type="text" readonly="readonly" value="${student.sex}"/>
                            </div>
                            <div class="field-box">
                                <label>出生日期:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.birthday}"/>
                            </div>
                            <div class="field-box">
                                <label>籍贯:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.residence}"/>
                            </div>
                            <div class="field-box">
                                <label>家庭居住地:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.nativePlace}"/>
                            </div>
                            <div class="field-box">
                                <label>专业:</label>
                                <input class="form-control" type="text" readonly="readonly" value="${student.major}"/>
                            </div>
                            <div class="field-box">
                                <label>就业单位:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.employmentUnit}"/>
                            </div>
                            <div class="field-box">
                                <label>辅导员姓名:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.counselorName}"/>
                            </div>
                            <div class="field-box">
                                <label>辅导员联系方式:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.counselorPhone}"/>
                            </div>
                            <div class="field-box">
                                <label>学生类型:</label>
                                <input class="form-control" type="text" readonly="readonly"
                                       value="${student.studentType}"/>
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
                                    <c:forEach var="parent" items="${parents}">
                                        <tr class="first">
                                            <td>
                                                <a class="name"><c:out value="${parent.name}"/> </a>
                                            </td>
                                            <td class="description">
                                                <c:out value="${parent.phone}"/>
                                            </td>
                                            <td>
                                                <span class="label label-success"><c:out value="${parent.relation}"/> </span>
                                            </td>
                                        </tr>
                                    </c:forEach>
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
                <div class="wizard-actions">
                    <button type="button" disabled class="btn-glow primary btn-prev">
                        <i class="icon-chevron-left"></i> 上一级
                    </button>
                    <button type="button" class="btn-glow primary btn-next" data-last="Finish">
                        下一级 <i class="icon-chevron-right"></i>
                    </button>
                    <button type="button" class="btn-glow success btn-finish">
                        审核通过
                    </button>
                    <button type="button" class="btn-glow success btn-finish">
                        审核不通过
                    </button>
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
</script>
</body>
</html>