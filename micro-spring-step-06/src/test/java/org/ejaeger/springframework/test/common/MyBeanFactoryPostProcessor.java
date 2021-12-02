package org.ejaeger.springframework.test.common;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.PropertyValue;
import org.ejaeger.springframework.beans.PropertyValues;
import org.ejaeger.springframework.beans.factory.ConfigurableListableBeanFactory;
import org.ejaeger.springframework.beans.factory.config.BeanDefinition;
import org.ejaeger.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * Created by zyp on 2021/12/2 10:04 上午
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition userService = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = userService.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：往生堂"));
    }
}
