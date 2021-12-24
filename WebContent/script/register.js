/**
 * 下拉选框选择家长账户时隐藏输入家长账户文本框
 */
function guardianSelected() {
    let guardianUser = document.getElementById("guardianUser")
    let guardianPassword = document.getElementById("guardianPassword")
    let content = document.getElementById("content")
    content.style.height = '550px'
    guardianUser.style.visibility = 'hidden'
    guardianUser.style.display = 'none'
    guardianPassword.style.visibility = 'hidden'
    guardianPassword.style.display = 'none'
}

/**
 * 下拉选框选择学生账户时显示输入家长账户文本框
 */
function studentSelected() {
    let guardianUser = document.getElementById("guardianUser")
    let guardianPassword = document.getElementById("guardianPassword")
    let content = document.getElementById("content")
    content.style.height = '650px'
    guardianUser.style.visibility = 'visible'
    guardianUser.style.display = 'table-row'
    guardianPassword.style.visibility = 'visible'
    guardianPassword.style.display = 'table-row'
}

/**
 * 在注册界面执行选择的相应账户类型的操作
 * @param accountType 选择的账户类型
 */
function accountSelected(accountType) {
    if (accountType == "student"){
        studentSelected()
    } else {
        guardianSelected()
    }
}