package org.ejaeger.springframework.factory.support;

import org.ejaeger.springframework.BeansException;
import org.ejaeger.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
