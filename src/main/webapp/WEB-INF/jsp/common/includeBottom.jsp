<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/8
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    var tabNames = ['sindex', 'basicInfo', 'parentsInfo', 'awardSitu', 'failexamSitu', 'withdrawInst','changePassword'];
    var tabparams = [[],[],[],[],[],[],[]];

    var contextPath = '<%=request.getContextPath()%>' + '/';

    for (var i = 0;i < tabNames.length;i++) {
        var base = contextPath + tabNames[i];
        for (var j = 0;j < tabparams[i].length;j++) {
            if (j == 0) {
                base = base + '?' + tabparams[i][j] + '=' + getCookie(tabparams[i][j]);
            } else {
                base = base + '&' + tabparams[i][i] + '=' + getCookie(tabparams[i][j]);
            }
        }
        $("#" + tabNames[i]).attr("href", base);
    }

</script>
</body>
</html>