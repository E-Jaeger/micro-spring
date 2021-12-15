package org.ejaeger.springframework.test;

import org.ejaeger.springframework.context.support.ClassPathXmlApplicationContext;
import org.ejaeger.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * Created by zyp on 2021/12/14 10:32 上午
 */
public class ApiTest {

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService1);
        System.out.println(userService2);

    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String s = userService.queryUserInfo();
        System.out.println(s);
    }
}
