package com.practice.starryfood.controller;

import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.service.VerifyCodeService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @Project starryfood
 * @ClassName VerifyCodeController
 * @Author StarryHu
 * @Description 验证码接口相关
 * @Date 2019/10/24 8:51
 */
@RestController
@RequestMapping("verifyCode")
public class VerifyCodeController extends BaseController{
    @Autowired
    private VerifyCodeService verifyCodeService;

    /***
    * @Description: 获取验证码图片
    * @Param: [request, response]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/10/24
    */
    @GetMapping("/get")
    BaseResponse get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 生成图片
        BufferedImage image = verifyCodeService.getImage();
        // 保存文本内容(小写)
        request.getSession().setAttribute("verify-code", verifyCodeService.getText().toLowerCase());
        // 输出图片
        ImageIO.write(image, "JPEG", response.getOutputStream());
        return ajaxSucc(null, ResultEnum.SUCCESS);
    }
}
