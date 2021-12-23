package cn.edu.ArithmeticTester.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成网站验证码
 * @author prinzeugen
 */
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 60;
        int height = 30;
        String code = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789abcdefghijklmnpqrstuvwxyz";
        Random random = new Random();
        //生产验证码图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //绘制边框
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, width-2, height-2);
        StringBuilder builder = new StringBuilder();
        //写入随机字符
        g.setFont(new Font("宋体", Font.BOLD&Font.ITALIC, 20));
        for (int i = 0; i < 4; i++) {
            g.setColor(new Color(random.nextInt(255),random.nextInt(255), random.nextInt(255)));
            int index = random.nextInt(code.length());
            String randomString = code.substring(index, index+1);
            builder.append(randomString);
            g.drawString(randomString, (width / 6) * (i + 1) , 20);
        }
        //生成随机噪点
        for(int j=0,n=random.nextInt(100);j<n;j++){
            g.setColor(Color.RED);
            g.fillRect(random.nextInt(width),random.nextInt(height),1,1);
        }
        String tempStr = builder.toString();
        System.out.println("tempStr:"+tempStr);
        req.getSession().setAttribute("sessionCacheKey",tempStr);
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}