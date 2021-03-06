/**
 * 模态框的样式在这里定义
 * @type {[*]}
 */
var modelForms = [[{label: '姓名:', id: 'parentName', type: 'text', placeholder: '请输入家长姓名'},
    {label: '联系方式:', id: 'parentPhone', type: 'text', placeholder: '请输入家长联系方式'},
    {label: '关系:', id: 'parentRelation', type: 'select', placeholder: '请输入与你的关系', options: ['父亲', '母亲']}],
    [{label: '姓名:', id: 'editName', type: 'text', placeholder: '请输入家长姓名', readonly: 'true'},
        {label: '联系方式:', id: 'editPhone', type: 'text', placeholder: '请输入家长联系方式'},
        {label: '关系:', id: 'editRelation', type: 'select', placeholder: '请输入与你的关系,如父亲或者母亲',options: ['父亲', '母亲']}],
    [{label: '获奖名称:', id: 'awardContent', type: 'text', placeholder: '请输入获奖名称'},
        {label: '获奖时间:', id: 'awardDate', type: 'text', placeholder: '请输入获奖时间，如2017-08-01'},
        {label: '获奖等级:', id: 'awardDegree', type: 'text', placeholder: '请输入获奖等级,如一等、二等、三等、优生'},
        {label: '获奖级别:', id: 'awardLevel', type: 'select', placeholder: '请输入获奖级别', options: ['国际级', '国家级', '省级', '市级', '校级', '院级']},
        {label: '获奖排名:', id: 'awardRank', type: 'text', placeholder: '请输入获奖排名, 如1、2、3'}],
    [{label: '获奖名称:', id: 'editContent', type: 'text', placeholder: '请输入获奖名称', readonly: 'true'},
        {label: '获奖时间:', id: 'editDate', type: 'text', placeholder: '请输入获奖时间，如2017-08-01', readonly: 'true'},
        {label: '获奖等级:', id: 'editDegree', type: 'text', placeholder: '请输入获奖等级,如一等、二等、三等、优生'},
        {label: '获奖级别:', id: 'editLevel', type: 'select', placeholder: '请输入获奖级别', options: ['国际级', '国家级', '省级', '市级', '校级', '院级']},
        {label: '获奖排名:', id: 'editRank', type: 'text', placeholder: '请输入获奖排名, 如1、2、3'}],
    [{label: '学期:', id: 'failedTerm', type: 'select', placeholder: '请输入学期，如2016-2017-2', options: ['2014-2015-1','2014-2015-2', '2015-2016-1', '2015-2016-2', '2016-2017-1', '2016-2017-2', '2017-2018-1', '2017-2018-2', '2018-2019-1', '2018-2019-2', '2019-2020-1', '2019-2020-2']},
        {label: '科目:', id: 'failedSubject', type: 'text', placeholder: '请输入科目'}],
    [{label: '学期:', id: 'editTerm', type: 'select', placeholder: '请输入学期，如2016-2017-2', options: ['2014-2015-1','2014-2015-2', '2015-2016-1', '2015-2016-2', '2016-2017-1', '2016-2017-2', '2017-2018-1', '2017-2018-2', '2018-2019-1', '2018-2019-2', '2019-2020-1', '2019-2020-2']},
        {label: '科目:', id: 'editSubject', type: 'text', placeholder: '请输入科目', readonly: 'true'}],
    [{label: '说明图片:', id: 'instPicture', type: 'file', placeholder: '请上传说明图片', accept: 'image/jpeg,image/png,image/gif', name: 'instPicture'},
        {label: '说明文字:', id: 'instComment', type: 'textarea', placeholder: '请输入说明文字', rows: 4}],
    [{label: '说明图片:', id: 'editPicture', type: 'file', placeholder: '请修改说明图片', accept: 'image/jpeg,image/png,image/gif', name: 'editPicture'},
        {label: '说明文字:', id: 'editComment', type: 'textarea', placeholder: '请输入说明文字', rows: 4}],
    [{type: 'img', id: 'viewInstPic'}]];

/**
 * 通过传入下标值获取模态框样式
 * @param index
 * @returns {*}
 */
function getModelForm(index) {
    return modelForms[index];
}

/**
 * 保存确认按钮函数
 */
var confirmEvent = function () {
    
};

/**
 * 赋值
 * @param feedback
 */
function setConfirmEvent(feedback) {
    confirmEvent = feedback;
}

/**
 * 执行确认函数
 */
function feedback() {
    confirmEvent();
}
/**
 *
 * @param title 模态框标题
 * @param rowNum 模态框表单行数
 * @param formArray 模态框表单每行表单组件类型包括label, id, type, placeholder,
 * @param feedback 当点击确定按钮时执行的函数
 * @param values 各个表单组件的初始值,可默认为空
 * @returns {*}
 */
function model(title, rowNum, rowObjArray, feedback, values) {
    function createModel() {

        if (feedback != undefined) {
            setConfirmEvent(feedback);
        }

        if (values == undefined){
            values = [];
            for (var i = 0;i < rowNum;i++) {
                values[i] = "";
            }
        }

        // var model = createElementWithAttribute("div",{class:'modal fade', id:'myModal', tabindex:-1, role:'dialog', 'aria-labelledby':'myModalLabel', 'aria-hidden':true});
        var dialog = createElementWithAttribute("div", {class: 'modal-dialog'});
        var content = createElementWithAttribute("div", {class: 'modal-content'});

        var header = createElementWithAttribute("div", {class: "modal-header"});
        header.appendChild(createElementWithHTML(createElementWithAttribute("button", {class: 'close', type: 'button', 'data-dismiss': 'modal', 'aria-hidden': true}), '&times;'));
        header.appendChild(createElementWithHTML(createElementWithAttribute("h4", {class:'modal-title'}), title));
        var body = createElementWithAttribute("div", {class: "modal-body"});
        if (rowObjArray[0].type == 'img') {
            body.appendChild(createElementWithAttribute("img", {src: values[0], id: rowObjArray[0].id, style: 'width:500px;height:500px'}));
        }else {
            body.appendChild(createForm(rowNum, rowObjArray, values));
        }
        var footer = createElementWithAttribute("div", {class: "modal-footer"});
        footer.appendChild(createElementWithHTML(createElementWithAttribute("button", {type: 'button', class: 'btn btn-default', 'data-dismiss': 'modal'}), '取消'));
        footer.appendChild(createElementWithHTML(createElementWithAttribute("button", {type: 'button', class: 'btn btn-primary', id: 'confirmAdd', onclick: 'feedback()'}), '确认'));
        content.appendChild(header);
        content.appendChild(body);
        content.appendChild(footer);
        dialog.appendChild(content);
        // model.appendChild(dialog);
        return [dialog, content];
    }
    
    function createForm(rowNum, objArray, values) {

        function createFormGroup() {
            return createElementWithAttribute("div", {class: 'form-group'});
        }

        var form = createElementWithAttribute("form", {class: 'form-horizontal', role: 'form'});

        for (var i = 0;i < rowNum;i++) {
            var formGroup = createFormGroup();
            formGroup.appendChild(createElementWithHTML(createElementWithAttribute("label", {for:objArray[i].id, class:"col-lg-2 control-label"}), objArray[i].label));
            var div = createElementWithAttribute("div", {class: "col-lg-10"});
            if (objArray[i].type == 'text'){
                if (objArray[i].readonly == 'true'){
                    div.appendChild(createElementWithAttribute("input", {type:objArray[i].type, class:"form-control", id:objArray[i].id, placeholder:objArray[i].placeholder, value: values[i], readonly: 'readonly'}));
                }else {
                    div.appendChild(createElementWithAttribute("input", {type:objArray[i].type, class:"form-control", id:objArray[i].id, placeholder:objArray[i].placeholder, value: values[i]}));
                }
            } else if (objArray[i].type == 'file') {
                div.appendChild(createElementWithAttribute("input", {type:objArray[i].type, class:"pull-left", id:objArray[i].id, placeholder:objArray[i].placeholder, value: values[i], accept: objArray[i].accept, name: objArray[i].name}));
            } else if (objArray[i].type == 'textarea') {
                div.appendChild(createElementWithHTML(createElementWithAttribute("textarea", {class: 'form-control', id: objArray[i].id, placeholder: objArray[i].placeholder, rows: objArray[i].rows}), values[i]));
            } else if  (objArray[i].type == 'select') {
                var selectElement = createElementWithAttribute("select", {class: 'form-control', id: objArray[i].id});
                var optionElement = undefined;
                for (var m = 0;m < objArray[i].options.length;m++) {
                    optionElement = createElementWithHTML(createElementWithAttribute("option", {value: objArray[i].options[m], }), objArray[i].options[m])
                    if (trim(values[i]) == trim(objArray[i].options[m])) optionElement.setAttribute("selected", "selected");
                    selectElement.appendChild(optionElement);
                }
                div.appendChild(selectElement);
            }
            formGroup.appendChild(div);
            form.appendChild(formGroup);
        }
        return form;
    }
    return createModel();
}

/**
 * 创建节点对象
 * @param name
 * @returns {Element}
 */
function createElement(name) {
    return document.createElement(name);
}

/**
 * 创建带属性的节点
 * @param name
 * @param obj
 * @returns {*}
 */
function createElementWithAttribute(name, obj) {
    return setAttribute(createElement(name), obj);
}

/**
 * 为节点添加文本
 * @param node
 * @param text
 * @returns {*}
 */
function createElementWithHTML(node, text) {
    node.innerHTML = text;
    return node;
}

/**
 * 为节点设置属性
 * @param element
 * @param obj
 * @returns {*}
 */
function setAttribute(element, obj) {
    for (var key in obj) {
        element.setAttribute(key, obj[key]);
    }
    return element;
}