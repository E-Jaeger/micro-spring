package org.ejaeger.springframework.test;

import org.ejaeger.springframework.context.support.ClassPathXmlApplicationContext;
import org.ejaeger.springframework.test.bean7.UserService;
import org.junit.Test;

/**
 * Created by zyp on 2021/12/2 11:11 上午
 */
public class ApiTest {

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String userInfo = userService.queryUserInfo();
        System.out.println("测试结果：" + userInfo);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }


}
