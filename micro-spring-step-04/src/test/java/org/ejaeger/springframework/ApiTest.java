package org.ejaeger.springframework;

import org.ejaeger.springframework.bean.UserDao;
import org.ejaeger.springframework.bean.UserService;
import org.ejaeger.springframework.factory.config.BeanDefinition;
import org.ejaeger.springframework.factory.config.BeanReference;
import org.ejaeger.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_PropertyValues() {
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("String", "胡桃"));
        propertyValues.addPropertyValue(new PropertyValue("Integer", "1"));
        PropertyValue[] propertyValues1 = propertyValues.getPropertyValues();
        for (PropertyValue pv : propertyValues1) {
            System.out.println(pv.getValue());
        }
    }

    @Test
    public void test_BeanFactory() {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));

        factory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));

        UserService userService = (UserService) factory.getBean("userService");
        userService.queryUserInfo();
    }

}
