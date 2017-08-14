<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/9
  Time: 0:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/teacIncludeTop.jsp" %>

<div id="pad-wrapper" class="form-page">
    <div class="row form-wrapper">
        <!-- left column -->
        <div class="col-md-8 column">
            <form>
                <div class="field-box">
                    <label>学工号:</label>
                    <div class="col-md-7">
                        <input class="form-control" type="text" readonly="readonly" value="${teacher.username}"
                               id="schoolWorkNum"/>
                    </div>
                </div>
                <div class="field-box">
                    <label>姓名:</label>
                    <div class="col-md-7">
                        <input class="form-control inline-input" type="text" readonly="readonly" value="${teacher.name}"
                               id="name">
                    </div>
                </div>
                <div class="field-box">
                    <label>联系方式:</label>
                    <div class="col-md-7">
                        <input class="form-control inline-input" type="text" value="${teacher.phone}" id="phone"/>
                    </div>
                </div>
                <div class="field-box">
                    <label>邮件:</label>
                    <div class="col-md-7">
                        <input class="form-control inline-input" type="text" value="${teacher.email}" id="email"/>
                    </div>
                </div>
                <div class="field-box">
                    <label>专业:</label>
                    <div class="col-md-7">
                        <select style="width:250px" class="select2" id="major">
                            <c:forEach var="item" items="${collegeList}">
                                <option value="${item}" <c:if test="${item == teacher.majors}">selected="selected"</c:if>>${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="field-box">
                    <label>辅导学生类型:</label>
                    <div class="col-md-7">
                        <input class="form-control inline-input" type="text" readonly="readonly" value="<c:if test="${teacher.role == 0}">本科生</c:if>
                            <c:if test="${teacher.role == 1}">研究生</c:if><c:if test="${teacher.role == 2}">高水平运动员</c:if>" id="type"/>
                    </div>
                </div>
                <div class="field-box">
                    <label class="text-success"></label>
                    <div class="col-md-4 actions">
                        <input id="confirmModify" class="form-control btn-flat primary" value="确认修改" type="button"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<!-- end main container -->

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/form-showcase.css" type="text/css" media="screen"/>
<!-- scripts for this page -->
<script src="js/wysihtml5-0.3.0.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.datepicker.js"></script>
<script src="js/jquery.uniform.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/widge/alert.js"></script>

<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {

        // add uniform plugin styles to html elements
        $("input:checkbox, input:radio").uniform();

        // select2 plugin for select elements
        $(".select2").select2({
            placeholder: "Select a State"
        });

        // datepicker plugin
        $('.input-datepicker').datepicker().on('changeDate', function (ev) {
            $(this).datepicker('hide');
        });
    });

    // alert
    $("#confirmModify").click(function () {
        var teacher = {};
        teacher.username = $('#schoolWorkNum').val();
        teacher.password =${teacher.password};
        teacher.name = $('#name').val();
        teacher.phone = $('#tel').val();
        teacher.majors = $('#major').val();
        teacher.role = $('#type').val();
        teacher.email = $('#email').val();
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'getInformation',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(teacher),
            success: function (data) {
                var result = data.result;
                if (result == success)
                    $("#myAlert").append(alert("success", "修改成功！"));
                else
                    $("#myAlert").append(alert("error", "修改失败！"));
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
</script>
<%@include file="../common/teacIncludeBottom.jsp" %>
