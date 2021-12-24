package cn.edu.ArithmeticTester.entity;

/**
 * @author prinz
 */
public class Forum {
    /**
     * num1 算式的第一位数
     * num2 算式的第二位数
     * option 算式的操作：
     *                  加法为1
     *                  减法为2
     *                  乘法为3
     *                  除法为4
     * result 算式的结果
     * opt 算式操作的符号
     * flag 标记该算式是否使用
     */
    private Integer num1 = 0;
    private Integer num2 = 0;
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
            //若第一位为负则设置为0
            if (num1 < 0){
                num1 = 0;
            }
            this.num1 = num1;
            //获取算式结果
            compute();
        }
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        //若第二位为负则设置为0
        if (num2 != null) {
            if (num2 < 0){
                num2 = 0;
            }
            this.num2 = num2;
            compute();
        }
    }

    public String getOption() {
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

    /**
     * 比较两个算式是否相同
     * @param obj 用于比较的另一个算式
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Forum newObj = (Forum) obj;
        if (this.num1.intValue() == newObj.num1.intValue() && this.num2.intValue() == newObj.num2.intValue() && this.option.intValue() == newObj.option.intValue()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算算式的结果
     * 如果结果过大或者结果为负数则弃用该算式
     */
    private void compute(){
        switch (option){
            //option值为2为减法
            case 2:
                opt = "-";
                //如果减法减数大于被减数，则互相交换，避免产生负数结果。
                if (num1 < num2){
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                result = num1 - num2;
                break;
                //option值为3为减法
            case 3:
                opt = "*";
                result = num1 * num2;
                //如果结果大于150则弃用该算式
                if (result > 150){
                    flag = false;
                }
                break;
                //option值为4为乘法
            case 4:
                if (num2!=0){
                    result = num1;
                    num1 = result * num2;
                    opt = "/";
                    //如果被除数大于150则弃用该算式
                    if (num1 > 150){
                        flag = false;
                    }
                } else {
                    flag = false;
                }
                break;
                //option值为1，默认为加法
            case 1:
            default:
                option = 1;
                opt = "+";
                result = num1 + num2;
                //如果结果大于150则弃用该算式
                if (result > 150){
                    flag = false;
                }
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
