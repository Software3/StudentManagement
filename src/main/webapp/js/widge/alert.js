function alertSuccess() {
    var alert = document.createElement("div");
    alert.setAttribute("class", "alert alert-success");
    alert.appendChild(getTagi());
    alert.appendChild(getTaga());
    alert.appendChild(getTagStrong());
    return alert;
}

function getTagi() {
    var i = document.createElement("i");
    i.setAttribute("class", "icon-ok-sign");
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

function getTagStrong() {
    var strong = document.createElement("strong");
    strong.innerHTML = "成功!";
    return strong;
}