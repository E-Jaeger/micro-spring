package org.ejaeger.springframework.factory;

import org.ejaeger.springframework.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

}
