package org.ejaeger.springframework.beans.factory.config;

import org.ejaeger.springframework.beans.BeansException;

/**
 * Created by zyp on 2021/11/29 5:19 下午
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
