package org.ejaeger.springframework.beans.factory.support;


import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 使用Bean名称查询BeanDefinition
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String name) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
