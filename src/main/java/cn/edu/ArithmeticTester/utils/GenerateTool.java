package cn.edu.ArithmeticTester.utils;

import cn.edu.ArithmeticTester.entity.Forum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author prinz
 */
public class GenerateTool {
    public static List<Forum> generate(int total, String opt){
         if (total <= 0){
             total = 10;
         }
         List<Forum> forumList = new ArrayList<>();
         Random random = new Random();
         do {
             int pos = random.nextInt(opt.length());
             String ch = opt.substring(pos, pos+1);
             int option = Integer.parseInt(ch);
             Forum forum = new Forum(random.nextInt(100), random.nextInt(100),option);
             if (!forumList.contains(forum) && forum.isFlag()){
                 forumList.add(forum);
                 total--;
             }
         }while (total > 0);
         return forumList;
    }
}
