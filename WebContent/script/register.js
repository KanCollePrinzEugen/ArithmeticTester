function passwordConfirmCheck(){

}

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

function accountSelected(accountType) {
    if (accountType == "student"){
        studentSelected()
    } else {
        guardianSelected()
    }
}