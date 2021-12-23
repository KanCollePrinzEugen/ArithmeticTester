package cn.edu.ArithmeticTester.entity;

/**
 * @author prinz
 */
public class Forum {
    private Integer num1 = 0;
    private Integer num2 = 0;
    /*1表示"+", 2表示"-"*/
    private Integer option = 1;
    private Integer result;
    private String opt = "+";
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        if (num1 != null) {
            if (num1 < 0){
                num1 = 0;
            }
            this.num1 = num1;
            compute();
        }
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        if (num2 != null) {
            if (num2 < 0){
                num2 = 0;
            }
            this.num2 = num2;
            compute();
        }
    }

    public String getOption(Integer option) {
        return opt;
    }

    public void setOption(Integer option) {
        this.option = option;
        compute();
    }

    public Integer getResult() {
        return result;
    }

    public Forum() {
    }

    public Forum(Integer num1, Integer num2, Integer option) {
        setNum1(num1);
        setNum2(num2);
        setOption(option);
    }

    @Override
    public boolean equals(Object obj) {
        Forum newObj = (Forum) obj;
        if (this.num1.intValue() == newObj.num1.intValue() && this.num2.intValue() == newObj.num2.intValue() && this.option.intValue() == newObj.option.intValue()){
            return true;
        } else {
            return false;
        }
    }

    private void compute(){
        switch (option){
            case 2:
                opt = "-";
                if (num1 < num2){
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                result = num1 - num2;
                break;
            case 3:
                opt = "*";
                result = num1 * num2;
                if (result > 200){
                    flag = false;
                }
                break;
            case 4:
                if (num2!=0){
                    result = num1;
                    num1 = result * num2;
                    opt = "/";
                    if (num1 > 200){
                        flag = false;
                    }
                } else {
                    flag = false;
                }
                break;
            case 1:
            default:
                option = 1;
                opt = "+";
                result = num1 + num2;
        }
    }

    @Override
    public String toString() {
        String operator = null;
        switch (option){
            case 1:
                operator = "+";
                break;
            case 2:
                operator = "-";
                break;
            case 3:
                operator = "*";
                break;
            case 4:
                operator = "/";
                break;
            default:
        }
        return num1 + operator + num2 + "=" + result;
    }
}
