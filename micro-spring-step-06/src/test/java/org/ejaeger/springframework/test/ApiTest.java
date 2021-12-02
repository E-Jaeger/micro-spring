package org.ejaeger.springframework.test;

import org.ejaeger.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.ejaeger.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.ejaeger.springframework.context.support.ClassPathXmlApplicationContext;
import org.ejaeger.springframework.test.bean.UserService;
import org.ejaeger.springframework.test.common.MyBeanFactoryPostProcessor;
import org.ejaeger.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * Created by zyp on 2021/12/2 9:37 上午
 */
public class ApiTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1. 初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件，注册beanDefinition
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 修改beanDefinition
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. 修改bean
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        String userInfo = userService.queryUserInfo();
        System.out.println(userInfo);
    }

    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = (UserService) applicationContext.getBean("userService", UserService.class);
        String userInfo = userService.queryUserInfo();
        System.out.println(userInfo);
    }
}
