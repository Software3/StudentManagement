

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
                    <label>原密码:</label>
                    <div class="col-md-7">
                        <input id="old_password" class="form-control" type="password"  onblur="checkPassword()"/>
                    </div>
                </div>
                <div class="field-box" style="display: none" id="newPasswordDiv">
                    <label>新密码:</label>
                    <div class="col-md-7">
                        <input id="new_password" class="form-control" type="password"/>
                    </div>
                </div>
                <div class="field-box" style="display: none" id="confirmPasswordDiv">
                    <label>确认密码:</label>
                    <div class="col-md-7">
                        <input id="confirm_password" class="form-control" type="password"/>
                    </div>
                </div>
                <div class="field-box" id="confirmChangeDiv" style="display: none">
                    <label class="text-success"></label>
                    <div class="col-md-4 actions">
                        <input id="confirmChangePassword" class="form-control btn-flat primary" value="确认修改" type="button" onclick="changeStuPassword()"/>
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
<script src="js/bootstrap.datepicker.js"></script>
<script src="js/jquery.uniform.min.js"></script>
<script src="js/select2.min.js"></script>
<script src="js/widge/alert.js"></script>
<script src="js/util/pwdManage.js"></script>
<script src="js/util/util.js"></script>
<!-- call this page plugins -->
<script type="text/javascript">
    $(function () {
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
<%@include file="../common/includeBottom.jsp" %>