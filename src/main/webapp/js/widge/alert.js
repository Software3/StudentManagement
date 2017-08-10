function alert(type, text) {

    function createAlert(type) {
        var alert = document.createElement("div");
        alert.setAttribute("class", getStyle(type)[0]);
        return alert;
    }

    function getTagi(type) {
        var i = document.createElement("i");
        i.setAttribute("class", getStyle(type)[1]);
        return i;
    }

    function getTaga() {
        var a = document.createElement("a");
        a.setAttribute("class", "close fade");
        a.setAttribute("href", "#");
        a.setAttribute("data-dismiss", "alert");
        a.innerHTML = "&times";
        return a;
    }

    function getTagStrong(text) {
        var strong = document.createElement("strong");
        strong.innerHTML = text;
        return strong;
    }

    function getStyle(type) {
        var alertStyle = "";
        var iconStyle = "";
        switch (type) {
            case "success":
                alertStyle = "alert alert-success";
                iconStyle = "icon-ok-sign";
                break;
            case "info":
                alertStyle = "alert alert-info";
                iconStyle = "icon-exclamation-sign";
                break;
            case "warning":
                alertStyle = "alert alert-warning";
                iconStyle = "icon-warning-sign";
                break;
            case "danger":
                alertStyle = "alert alert-danger";
                iconStyle = "icon-remove-sign";
                break;
        }
        return [alertStyle, iconStyle];
    }
    if (type == undefined) type = "success";
    if (text == undefined) text = "操作成功!"

    var alert = createAlert(type);
    alert.appendChild(getTagi(type));
    alert.appendChild(getTaga());
    alert.appendChild(getTagStrong(text));
    return alert;
}