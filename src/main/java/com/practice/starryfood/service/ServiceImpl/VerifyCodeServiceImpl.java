package com.practice.starryfood.service.ServiceImpl;

import com.practice.starryfood.service.VerifyCodeService;
import com.practice.starryfood.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @Project starryfood
 * @ClassName VerifyCodeServiceImpl
 * @Author StarryHu
 * @Description 验证码相关业务逻辑实现
 * @Date 2019/10/24 8:56
 */
@Service("verifyCode")
public class VerifyCodeServiceImpl implements VerifyCodeService {
    private VerifyCode verifyCode = new VerifyCode();
    private Random random = new Random();

    /***
     * @Description: 生成4个字符的随机码图片
     * @Param: []
     * @return: java.awt.image.BufferedImage
     * @Author: StarryHu
     * @Date: 2019/10/24
     */
    public BufferedImage getImage () {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        StringBuilder sb = new StringBuilder();
        // 向图片中画4个字符
        for(int i = 0; i < 4; i++)  {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * verifyCode.getW() / 4;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(s, x, verifyCode.getH()-5);
        }
        verifyCode.setText(sb.toString());
        drawLine(image);
        return image;
    }

    /***
     * @Description: 获取该图片的字符文本
     * @Param: []
     * @return: java.lang.String
     * @Author: StarryHu
     * @Date: 2019/10/24
     */
    public String getText () {
        return verifyCode.getText();
    }

    /***
     * @Description: 输出图片
     * @Param: [image, out]
     * @return: void
     * @Author: StarryHu
     * @Date: 2019/10/24
     */
    public static void output (BufferedImage image, OutputStream out)
            throws IOException {

    }


    // 随机设置颜色
    private Color randomColor () {
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red, green, blue);
    }

    // 随机设置字体
    private Font randomFont () {
        String fontName[] = verifyCode.getFontNames();
        int index = random.nextInt(fontName.length);
        String oneFontName = fontName[index];
        int style = random.nextInt(4);
        int size = random.nextInt(5) + 24;
        return new Font(oneFontName, style, size);
    }

    // 设置干扰线
    private void drawLine (BufferedImage image) {
        int num  = 3;
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        for(int i = 0; i < num; i++) {
            int w = verifyCode.getW();
            int h = verifyCode.getH();

            int x1 = random.nextInt(w);
            int y1 = random.nextInt(h);
            int x2 = random.nextInt(w);
            int y2 = random.nextInt(h);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    // 随机设置字符
    private char randomChar () {
        String codes = verifyCode.getCodes();
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    // 根据相关参数，创建图片
    private BufferedImage createImage () {
        BufferedImage image = new BufferedImage(verifyCode.getW(), verifyCode.getH(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        g2.setColor(verifyCode.getBgColor());
        g2.fillRect(0, 0, verifyCode.getW(), verifyCode.getH());
        return image;
    }
}
