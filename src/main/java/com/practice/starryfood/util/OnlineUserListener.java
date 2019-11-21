package com.practice.starryfood.util;

import com.practice.starryfood.bean.Customer;
import org.apache.catalina.manager.util.SessionUtils;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @Project starryfood
 * @ClassName OnlineUser
 * @Author StarryHu
 * @Description 在线人数的统计
 * @Date 2019/11/19 8:37
 */

@WebListener
public class OnlineUserListener implements HttpSessionListener {
    public static int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        online ++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
        online --;
    }
}
