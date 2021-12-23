package test;

import cn.edu.ArithmeticTester.utils.GenerateTool;
import org.testng.annotations.Test;

public class TestGenerateTool {
    @Test
    public void testGenerate(){
        System.out.println(GenerateTool.generate(10, "41"));
    }
}
