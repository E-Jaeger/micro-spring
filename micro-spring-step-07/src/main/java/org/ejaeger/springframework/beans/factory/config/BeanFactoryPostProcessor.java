package org.ejaeger.springframework.beans.factory.config;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * Created by zyp on 2021/11/29 2:59 下午
 */
public interface BeanFactoryPostProcessor {

    /**
     * 修改beanDefinition
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
