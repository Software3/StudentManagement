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
                            <input class="form-control" type="text" readonly="readonly" value="3903150326" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>姓名:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" type="text" readonly="readonly" value="李涛江">
                        </div>
                    </div>
                    <div class="field-box">
                        <label>性别:</label>
                        <div class="col-md-7">
                            <select style="width:250px" class="select2">
                                <option value="male">男</option>
                                <option value="female">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-box">
                        <label>出生日期:</label>
                        <div class="col-md-7">
                            <input type="text" value="03/29/2013" class="form-control input-datepicker" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>籍贯:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" data-toggle="tooltip" data-trigger="focus" title="请输入籍贯" data-placement="top" type="text" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>家庭居住地:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" data-toggle="tooltip" data-trigger="focus" title="请输入详细的家庭居住地" data-placement="top" type="text" />
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
                            <select style="width:250px" class="select2">
                                <option></option>
                                <option value="SE">软件工程</option>
                                <option value="CS">计算机科学与技术</option>
                            </select>
                        </div>
                    </div>
                    <div class="field-box">
                        <label>就业单位:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" data-toggle="tooltip" data-trigger="focus" title="请输入就业单位" data-placement="top" type="text" value="中南大学" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>辅导员姓名:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" type="text" value="罗俊" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>辅导员联系方式:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" type="text" value="15537397854" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>学生类型:</label>
                        <div class="col-md-7">
                            <input class="form-control inline-input" type="text" readonly="readonly" value="本科生" />
                        </div>
                    </div>
                    <div class="field-box">
                        <label>备注:</label>
                        <div class="col-md-7">
                            <textarea class="form-control" rows="4"></textarea>
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
        </div>
    </div>
</div>
<!-- end main container -->

<!-- this page specific styles -->
<link rel="stylesheet" href="css/compiled/form-showcase.css" type="text/css" media="screen" />
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
            placeholder: "请选择专业"
        });

        // datepicker plugin
        $('.input-datepicker').datepicker().on('changeDate', function (ev) {
            $(this).datepicker('hide');
        });

        // alert
        $("#confirmModify").click(function () {
            $("#myAlert").append(alert("success", "修改成功！"));
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
    });
</script>
</body>
</html>
