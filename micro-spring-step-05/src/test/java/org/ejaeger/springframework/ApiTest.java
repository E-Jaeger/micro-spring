package org.ejaeger.springframework;

import cn.hutool.core.io.IoUtil;
import org.ejaeger.springframework.bean.UserDao;
import org.ejaeger.springframework.bean.UserService;
import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.PropertyValue;
import org.ejaeger.springframework.beans.PropertyValues;
import org.ejaeger.springframework.beans.factory.config.BeanDefinition;
import org.ejaeger.springframework.beans.factory.config.BeanReference;
import org.ejaeger.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.ejaeger.springframework.core.io.DefaultResourceLoader;
import org.ejaeger.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    private DefaultResourceLoader defaultResourceLoader;

    @Test
    public void test_BeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        factory.registerBeanDefinition("userService", userServiceBeanDefinition);

        UserService userService = (UserService) factory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Before
    public void init() {
        this.defaultResourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws BeansException, IOException {
        Resource resource = defaultResourceLoader.getResource("classpath:important.properties");
        String content = IoUtil.readUtf8(resource.getInputStream());
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = defaultResourceLoader.getResource("src/test/resources/important.properties");
        String content = IoUtil.readUtf8(resource.getInputStream());
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = defaultResourceLoader.getResource("src/test/resources/important.properties");
        String content = IoUtil.readUtf8(resource.getInputStream());
        System.out.println(content);
    }



}
