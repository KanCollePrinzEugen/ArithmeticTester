var count = 0
var answerArr = new Array();
function displayForum(num1, num2, opt) {
    let option
    switch (opt) {
        case "+":
            option = "+"
            break;
        case "-":
            option = "-"
            break;
        case "*":
            option = "×"
            break;
        case "/":
            option = "÷"
            break;
    }
    return num1 + option + num2 + "="
}