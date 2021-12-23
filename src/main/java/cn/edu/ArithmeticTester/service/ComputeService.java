package cn.edu.ArithmeticTester.service;

import cn.edu.ArithmeticTester.entity.Forum;
import cn.edu.ArithmeticTester.utils.GenerateTool;

import java.util.List;

/**
 * @author prinz
 */
public class ComputeService {
    public List<Forum> generateForums(int total, String opt){
        return GenerateTool.generate(total, opt);
    }
}
