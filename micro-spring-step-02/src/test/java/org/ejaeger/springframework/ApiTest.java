package org.ejaeger.springframework;

import org.ejaeger.springframework.bean.UserService;
import org.ejaeger.springframework.factory.config.BeanDefinition;
import org.ejaeger.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
        System.out.println(userService == userService1);
        System.out.println(userService);
        System.out.println(userService1);
    }
}
