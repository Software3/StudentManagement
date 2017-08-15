<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/9
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/includeTop.jsp" %>

    <div id="pad-wrapper" class="form-page">
        <div class="row form-wrapper">
            <!-- left column -->
            <div class="col-md-8 column">
                <form>
                    <div class="field-box">
                        <label>学号:</label>
                        <div class="col-md-7">
                            <input id="studentId" class="form-control" type="text" readonly="readonly" value="<c:out value='${student.studentId}'/>" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>姓名:</label>
                        <div class="col-md-7">
                            <input id="name" class="form-control inline-input" type="text" readonly="readonly" value="<c:out value='${student.name}'/>">
                        </div>
                    </div>
                    <div class="field-box">
                        <label>性别:</label>
                        <div class="col-md-7">
                            <select id="sex" style="width:250px" class="select2">
                                <option value="1" <c:if test='${student.sex == 1}'>selected="true"</c:if>">男</option>
                                <option value="0" <c:if test='${student.sex == 0}'>selected="true"</c:if>">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-box">
                        <label>出生日期:</label>
                        <div class="col-md-7">
                            <input id="birthday" type="text" placeholder="请填写出生日期，格式:2017-05-01" value="<c:out value="${student.birthday}"/>" class="form-control inline-input" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>籍贯:</label>
                        <div class="col-md-7">
                            <input id="nativePlace" class="form-control inline-input" value="<c:out value="${student.nativePlace}"/>" data-toggle="tooltip" data-trigger="focus" title="请输入籍贯" data-placement="top" type="text" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>家庭居住地:</label>
                        <div class="col-md-7">
                            <input id="residence" class="form-control inline-input" value="<c:out value="${student.residence}"/>" data-toggle="tooltip" data-trigger="focus" title="请输入详细的家庭居住地" data-placement="top" type="text" />
                        </div>
                        <%--<div class="col-md-7">--%>
                            <%--<div class="predefined">--%>
                                <%--<span class="value">http://</span>--%>
                                <%--<input class="form-control inline-input" type="text">--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                    <div class="field-box">
                        <label>专业:</label>
                        <div class="col-md-7">
                            <select id="major" style="width:250px" class="select2">
                                <c:forEach var="item" items="${collegeList}">
                                    <option value="${item}" <c:if test="${item == student.major}">selected="selected"</c:if>>${item}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="field-box">
                        <label>就业单位:</label>
                        <div class="col-md-7">
                            <input id="employmentUnit" class="form-control inline-input" value="<c:out value="${student.employmentUnit}"/>" data-toggle="tooltip" data-trigger="focus" title="请输入就业单位" data-placement="top" type="text" value="中南大学" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>辅导员姓名:</label>
                        <div class="col-md-7">
                            <input id="counselorName" class="form-control inline-input" value="<c:out value="${student.counselorName}"/>" type="text" value="罗俊" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>辅导员联系方式:</label>
                        <div class="col-md-7">
                            <input id="counselorPhone" class="form-control inline-input" value="<c:out value="${student.counselorPhone}"/>" type="text" value="15537397854" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>学生类型:</label>
                        <div class="col-md-7">
                            <input id="studentType" class="form-control inline-input" type="text" readonly="readonly" value="<c:if test="${student.studentType == 0}">本科生</c:if><c:if test="${student.studentType == 1}">研究生</c:if><c:if test="${student.studentType == 2}">高水平运动员</c:if>" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>备注:</label>
                        <div class="col-md-7">
                            <textarea id="remarks" class="form-control" rows="4"><c:out value="${student.remarks}"/></textarea>
                        </div>
                    </div>
                    <div class="field-box">
                        <label class="text-success"></label>
                        <div class="col-md-4 actions">
                            <input id="confirmModify" class="form-control btn-flat primary" value="确认修改" type="button" />
                        </div>
                    </div>
                </form>
            </div>

            <!-- right column -->
            <div class="col-md-4 column pull-right">
                <c:if test="${student.verifyState == 0 || student.verifyState == 3}">
                    <a id="submitVerify" class="btn btn-danger">提交资料审核</a><br/><br/>
                    <h5 class="text-info">注意:资料提交审核成功后，您的资料将不能再进行更改</h5>
                    <span><c:out value="${student.verifyState}"/></span>
                </c:if>
            </div>
        </div>
    </div>
</div>
<!-- end main container -->

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/form-showcase.css" type="text/css" media="screen" />
<!-- scripts for this page -->
<script src="js/wysihtml5-0.3.0.js"></script>
<script src="js/bootstrap.datepicker.js"></script>
<script src="js/jquery.uniform.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/widge/alert.js"></script>
<script src="js/util/basicInfoAjax.js"></script>
<script src="js/util/util.js"></script>
<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {

        // add uniform plugin styles to html elements
        $("input:checkbox, input:radio").uniform();

        // select2 plugin for select elements
        $(".select2").select2({
            placeholder: "请选择专业"
        });

        // datepicker plugin
        $('.input-datepicker').datepicker().on('changeDate', function (ev) {
            $(this).datepicker('hide');
        });

        // alert
        $("#confirmModify").click(function () {
            updateBasicInfo();
        });

        // alert position when scroll
        $(function () {
            var elm = $('#myAlert');
            var startPos = $(elm).offset().top;
            $.event.add(window, "scroll", function () {
                var p = $(window).scrollTop();
                $(elm).css('position', ((p) > startPos) ? 'fixed' : 'static');
                $(elm).css('top', ((p) > startPos) ? '0px' : '');
            });
        });

        $("#submitVerify").click(function () {
            submitVerify($(this))
        });
    });
</script>
<%@include file="../common/includeBottom.jsp" %>
