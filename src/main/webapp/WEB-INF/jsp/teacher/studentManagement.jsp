<%--
  Created by IntelliJ IDEA.
  User: 51157
  Date: 2017/8/14
  Time: 20:38
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
                <h4>学生管理</h4>
            </div>
        </div>


        <div class="row">
            <div class="col-md-4 column">
                <input id="confirmModify" class="form-control btn-flat primary" download="学生基本信息.xlsx" value="一键导出"
                       type="button"
                       onclick="exportf()"/>
                <br/>
                <br/>
                <input type="file" name="file1" size="30" onchange="setObj(this)"/>
                <input class="form-control btn-flat primary"
                       onclick="importf()" type="button" value="一键上传"/>
            </div>
        </div>
        <!-- end products table -->
    </div>
</div>
</div>
<script src="js/jquery/jquery.min.js"></script>
<script src="js/js-xlsx/shim.js"></script>
<script src="js/js-xlsx/xlsx.full.min.js"></script>
<script>
    /*
     FileReader共有4种读取方法：
     1.readAsArrayBuffer(file)：将文件读取为ArrayBuffer。
     2.readAsBinaryString(file)：将文件读取为二进制字符串
     3.readAsDataURL(file)：将文件读取为Data URL
     4.readAsText(file, [encoding])：将文件读取为文本，encoding缺省值为'UTF-8'
     */
    var obj;
    var wb;//读取完成的数据
    var rABS = false; //是否将文件读取为二进制字符串
    function setObj(objt) {
        obj = objt;
    }
    function importf(t) {//导入
        if (!obj.files) {
            return;
        }
        var f = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var data = e.target.result;
            if (rABS) {
                wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                    type: 'base64'
                });
            } else {
                wb = XLSX.read(data, {
                    type: 'binary'
                });
            }
            //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
            //wb.Sheets[Sheet名]获取第一个Sheet的数据
            var list = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]);
            assemble(list);
        };
        if (rABS) {
            reader.readAsArrayBuffer(f);
        } else {
            reader.readAsBinaryString(f);
        }
    }
    function assemble(list) {
        var url;
        var tep_list;
        url = 'importInfo';
        tep_list = new Array(list.length);
        for (var i = 0; i < list.length; i++) {
            tep_list[i] = '{' +
                '"studentId":' + '"' + list[i]["学号"] + '"' + ',' +
                '"name":' + '"' + list[i]['姓名'] + '"' + ',' +
                '"sex":' + '"' + list[i]['性别'] + '"' + ',' +
                '"residence":' + '"' + list[i]['居住地'] + '"' + ',' +
                '"birthday":' + '"' + list[i]['出生日期'] + '"' + ',' +
                '"nativePlace":' + '"' + list[i]['家庭居住地'] + '"' + ',' +
                '"major":' + '"' + list[i]['专业'] + '"' + ',' +
                '"employmentUnit":' + '"' + list[i]["就业单位"] + '"' + ',' +
                '"remarks":' + '"' + list[i]["备注"] + '"' + ',' +
                '"counselorName":' + '"' + list[i]["辅导员学工号"] + '"' + ',' +
                '"counselorPhone":' + '"' + list[i]["辅导员联系方式"] + '"' + ',' +
                '"studentType":' + '"' + list[i]["学生类型"] + '"' +
                '}';
        }
        $.ajaxSetup({contentType: 'application/json'});
        $.ajax({
            url: url,
            dataType: 'json',
            method: 'POST',
            data: '[' + tep_list + ']',
            success: function (data) {

            }
            ,
            error: function (xhr) {
                // 导致出错的原因较多，以后再研究
                alert("导入信息有误，请联系管理员");
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
    }

    function fixdata(data) { //文件流转BinaryString
        var o = "",
            l = 0,
            w = 10240;
        for (; l < data.byteLength / w; ++l) o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w, l * w + w)));
        o += String.fromCharCode.apply(null, new Uint8Array(data.slice(l * w)));
        return o;
    }

    function exportf() {
        $.ajax({
            url: "exportInfo",
            dataType: 'json',
            method: 'GET',
            success: function (data) {
                var students = data.object;
                downloadExl(students);
            }
            ,
            error: function (xhr) {
                // 导致出错的原因较多，以后再研究
                alert("导入信息有误，请联系管理员");
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
    }

    function saveAs(obj, fileName) {//当然可以自定义简单的下载文件实现方式
        var tmpa = document.createElement("a");
        tmpa.download = fileName || "下载";
        tmpa.href = URL.createObjectURL(obj); //绑定a标签
        tmpa.click(); //模拟点击实现下载
        setTimeout(function () { //延时释放
            URL.revokeObjectURL(obj); //用URL.revokeObjectURL()来释放这个object URL
        }, 100);
    }
    const wopts = {bookType: 'xlsx', bookSST: false, type: 'binary'};//这里的数据是用来定义导出的格式类型
    // const wopts = { bookType: 'csv', bookSST: false, type: 'binary' };//ods格式
    // const wopts = { bookType: 'ods', bookSST: false, type: 'binary' };//ods格式
    // const wopts = { bookType: 'xlsb', bookSST: false, type: 'binary' };//xlsb格式
    // const wopts = { bookType: 'fods', bookSST: false, type: 'binary' };//fods格式
    // const wopts = { bookType: 'biff2', bookSST: false, type: 'binary' };//xls格式

    function downloadExl(data) {
        const wb = {SheetNames: ['Sheet1'], Sheets: {}, Props: {}};
        wb.Sheets['Sheet1'] = XLSX.utils.json_to_sheet(data);//通过json_to_sheet转成单页(Sheet)数据
        saveAs(new Blob([s2ab(XLSX.write(wb, wopts))], {type: "application/octet-stream"}), "学生基本信息" + '.' + (wopts.bookType == "biff2" ? "xls" : wopts.bookType));
    }
    function s2ab(s) {
        if (typeof ArrayBuffer !== 'undefined') {
            var buf = new ArrayBuffer(s.length);
            var view = new Uint8Array(buf);
            for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
            return buf;
        } else {
            var buf = new Array(s.length);
            for (var i = 0; i != s.length; ++i) buf[i] = s.charCodeAt(i) & 0xFF;
            return buf;
        }
    }
</script>

<%@include file="../common/teacIncludeBottom.jsp" %>