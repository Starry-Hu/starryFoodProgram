package com.practice.starryfood.service;

import java.awt.image.BufferedImage;

public interface VerifyCodeService {
    // 生成验证码
    BufferedImage getImage ();

    // 获取该图片的字符文本
    String getText ();
}
