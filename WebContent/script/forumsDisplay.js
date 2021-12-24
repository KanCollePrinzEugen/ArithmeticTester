var count = 0
var answerArr = new Array();

/**
 * 将生产算式以平常的运算符号显示
 * @param num1 第一位操作数
 * @param num2 第二位操作数
 * @param opt  算式原来的运算符号
 * @returns {string} 将第一位操作数、对应的标准运算符号、第二位操作数和等号拼接返回
 */
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