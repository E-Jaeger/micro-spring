package org.ejaeger.springframework.beans.factory.config;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.BeanFactory;

/**
 * Created by zyp on 2021/11/29 3:24 下午
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
