package com.practice.starryfood.util;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @Project starryfood
 * @ClassName VerifyCode
 * @Author StarryHu
 * @Description 随机生成验证码
 * @Date 2019/10/24 8:21
 */
public class VerifyCode {
    //图片的宽高
    private int w = 70;
    private int h = 35;
    // 各符号的字体
    private String[] fontNames  = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    // 可选字符组成的字符串
    private String codes  = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
    // 图片的背景颜色
    private Color bgColor  = new Color(255, 255, 255);
    // 字符文本 - 用于比较
    private String text ;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String[] getFontNames() {
        return fontNames;
    }

    public void setFontNames(String[] fontNames) {
        this.fontNames = fontNames;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
