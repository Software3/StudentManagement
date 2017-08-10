/**
 * 模态框的样式在这里定义
 * @type {[*]}
 */
var modelForms = [[{label: '姓名:', id: 'parentName', type: 'text', placeholder: '请输入家长姓名'},
    {label: '联系方式:', id: 'parentPhone', type: 'text', placeholder: '请输入家长联系方式'},
    {label: '关系:', id: 'parentRelation', type: 'text', placeholder: '请输入与你的关系'}],];

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
        body.appendChild(createForm(rowNum, rowObjArray, values));
        var footer = createElementWithAttribute("div", {class: "modal-footer"});
        footer.appendChild(createElementWithHTML(createElementWithAttribute("button", {type: 'button', class: 'btn btn-default', 'data-dismiss': 'modal'}), '关闭'));
        footer.appendChild(createElementWithHTML(createElementWithAttribute("button", {type: 'button', class: 'btn btn-primary', id: 'confirmAdd', onclick: 'feedback()'}), '确认添加'));
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
            div.appendChild(createElementWithAttribute("input", {type:objArray[i].type, class:"form-control", id:objArray[i].id, placeholder:objArray[i].placeholder, value: values[i]}));
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