package cn.edu.ArithmeticTester.utils;

import cn.edu.ArithmeticTester.entity.Forum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生产算式的类
 * @author prinz
 */
public class GenerateTool {
    /**
     * 生产指定数量和运算规则的算式
     * @param total 生成的算式数
     * @param opt   指定的四则运算规则
     * @return 返回生产的算式的List
     */
    public static List<Forum> generate(int total, String opt){
        //输入非法值默认生产十个算式（但是我在servlet已经设置了输入非法值重新载入网页）
         if (total <= 0){
             total = 10;
         }
         List<Forum> forumList = new ArrayList<>();
         Random random = new Random();
         //生产随机算式并包装进forumList
         do {
             int pos = random.nextInt(opt.length());
             String ch = opt.substring(pos, pos+1);
             int option = Integer.parseInt(ch);
             //随机生成算式
             Forum forum = new Forum(random.nextInt(100), random.nextInt(100),option);
             //如果算式没有被弃用则将其添加到forumList里
             if (!forumList.contains(forum) && forum.isFlag()){
                 forumList.add(forum);
                 total--;
             }
         }while (total > 0);
         return forumList;
    }
}
