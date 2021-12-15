package org.ejaeger.springframework.beans.factory;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.ejaeger.springframework.beans.factory.config.BeanDefinition;
import org.ejaeger.springframework.beans.factory.config.BeanPostProcessor;
import org.ejaeger.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Created by zyp on 2021/11/29 3:22 下午
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
