/**
 * 读取cookie
 * @param c_name
 * @returns {string}
 */
function getCookie(c_name)
{
    if (document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1)
        {
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}

/**
 * 创建cookie
 * @param c_name
 * @param value
 * @param expiredays
 */
function setCookie(c_name,value,expiredays)
{
    var exdate=new Date()
    exdate.setDate(exdate.getDate()+expiredays)
    document.cookie=c_name+ "=" +escape(value)+
        ((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}

/**
 * 将学生对象保存为cookie
 * @param student
 */
function saveStudent(student) {
    for (var key in student) {
        setCookie(key, student[key]);
    }
}

/**
 * 将教师对象保存为cookie
 * @param teacher
 */
function saveTeacher(teacher) {
    for (var key in teacher) {
        setCookie(key, teacher[key]);
    }
}
/**
 * 获取学号
 * @returns {string}
 */
function getStudentId() {
    return getCookie("studentId");
}

/**
 * 获取用户名
 * @returns {string}
 */
function getTeacherId() {
    return getCookie("username");
}