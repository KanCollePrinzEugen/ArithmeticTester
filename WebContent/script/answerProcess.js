function answerProcess(){
    for (let i = 1; i <= count; i++) {
        // console.log(i+":"+document.getElementById("answerInput"+i.toString()))
        var elementId ="answerInput"+i.toString()
        document.write(elementId)
        document.write(document.getElementById(elementId).value)
        // document.write("answerInput"+i.toString()+" ")
        // document.write(i+":"+document.getElementById("answerInput"+i.toString()))
    }
}