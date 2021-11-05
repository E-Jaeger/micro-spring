package org.ejaeger.springframework;

import org.ejaeger.springframework.bean.UserService;

public class ApiTest {
    public static void main(String[] args) {
        test_BeanFactory();
    }

    public static void test_BeanFactory(){
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
