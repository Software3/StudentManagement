

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/teacIncludeTop.jsp" %>
<div class="modal fade" id="searchListModal" data-backdrop="static">
    <div class="modal-dialog" style="width:800px;height:500px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal"
                        aria-hidden="true">x
                </button>
            </div>
            <div class="modal-body" >
                <form class="bs-example bs-example-form" method="post">
                    <div id="searchContent">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="col-md-1">
                                    姓名
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    学号
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    性别
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    出生日期
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    家庭地址
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    籍贯
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    专业
                                </th>
                                <th class="col-md-1">
                                    <span class="line"></span>
                                    学生类型
                                </th>
                            </tr>
                            </thead>
                            <tbody id="studentList">
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<div id="pad-wrapper" class="form-page">
    <div class="row form-wrapper">
        <!-- left column -->
        <div class="col-md-8 column">
            <form>
                <div class="field-box">
                    <label>学号:</label>
                    <div class="col-md-3">
                        <input id="search_studentId" class="form-control" type="text"/>
                    </div>
                </div>
                <div class="field-box">
                    <label>姓名:</label>
                    <div class="col-md-3">
                        <input id="search_name" class="form-control" type="text"/>
                    </div>
                </div>
                <div class="field-box">
                    <label>籍贯:</label>
                    <div class="col-md-3">
                        <input id="search_place" class="form-control" type="text" placeholder="例：湖南长沙"/>
                    </div>
                </div>
                <div class="field-box">
                    <label>专业:</label>&nbsp;
                    <div class="ui-select span5">
                        <select id="search_major">
                            <option value="无"></option>
                            <option value="软件工程">软件工程</option>
                            <option value="土木工程">土木工程</option>
                        </select>
                    </div>
                </div>
                <div class="field-box">
                    <label>学生类型:</label>&nbsp;
                    <div class="ui-select span5">
                        <select id="search_type">
                            <option value="无"></option>
                            <option value="本科生">本科生</option>
                            <option value="研究生">研究生</option>
                            <option value="运动员">运动员</option>
                        </select>
                    </div>
                </div>
                <div class="field-box" id="confirmChangeDiv">
                    <label class="text-success"></label>
                    <div class="col-md-3 actions">
                        <input id="search" class="form-control btn-flat primary" value="查询" type="button"
                               onclick="searchStudents()"/>
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
<script src="js/jquery-latest.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/theme.js"></script>
<script src="js/fuelux.wizard.js"></script>
<!-- call this page plugins -->
<script>
    function searchStudents() {
        var studentId=$('#search_studentId').val();
        var name=$('#search_name').val();
        var nativeplace=$('#search_place').val();
        var major=$('#search_major option:selected').val();
        var type=$('#search_type option:selected').val();
        var searchInfo = {studentId: studentId, name: name,nativePlace:nativeplace,major:major,type:type};
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: 'searchStudentInfo',
            dataType: 'json',
            method: 'POST',
            data: JSON.stringify(searchInfo),
            success: function (data) {
                $('#studentList').html("");
                for (var i = 0; i < data.length; i++) {
                    $('#studentList').append("<tr class=\"first\">" +
                        "<td>" +
                        "<a >" + data[i].name + "</a>" +
                        "</td>" +
                        "<td class=\"description\">" +
                        data[i].studentId +
                        "</td>" +
                        "<td>" +
                        data[i].sex+
                        "</td>" +
                        "<td>" +
                        data[i].birthday+
                        "</td>" +
                        "<td>" +
                        data[i].residence+
                        "</td>" +
                        "<td>" +
                        data[i].nativePlace+
                        "</td>" +
                        "<td>" +
                        data[i].major+
                        "</td>" +
                        "<td>" +
                        data[i].studentType+
                        "</td>" +
                        "</tr>"
                    )
                    ;
                }
               $('#searchListModal').modal("show");
            },
            error: function (xhr) {
                $("#myAlert").append(alert("danger", "查询失败！"));
            }
        })
    }
</script>
<%@include file="../common/teacIncludeBottom.jsp" %>