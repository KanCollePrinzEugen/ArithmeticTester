package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.entity.Forum;
import cn.edu.ArithmeticTester.utils.GenerateTool;

import java.util.List;

/**
 * @author prinz
 */
public class ComputeService {
    /**
     * 生产指定数量和指定四则运算的算式
     * @param total 生产的算式
     * @param opt 指定的四则运算种类
     * @return
     */
    public List<Forum> generateForums(int total, String opt){
        return GenerateTool.generate(total, opt);
    }
}
