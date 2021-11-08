package org.ejaeger.springframework.factory.support;

import org.ejaeger.springframework.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
