function trim(str){ //删除左右两端的空格
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
function ltrim(str){ //删除左边的空格
    return str.replace(/(^\s*)/g,"");
}
function rtrim(str){ //删除右边的空格
    return str.replace(/(\s*$)/g,"");
}

/**
 * 转换时间 eg.08/11/2017 to 2017-11-08
 * @param date eg.08/11/2017
 */
function formatDateToYYYYmmdd(date) {
    var ddmmYYYY = date.split('/');
    return [ddmmYYYY[2], ddmmYYYY[1], ddmmYYYY[0]].join('-');
}

/**
 * 获取学生类型值
 * @param textType
 * @returns {number}
 */
function getStudentType(textType) {
    var type = 0;
    if (textType == '本科生') {
        type = 0;
    } else if (textType == '研究生') {
        type = 1;
    } else if (textType == '高水平运动员') {
        type = 2;
    }
    return type;
}