package org.ejaeger.springframework.beans.factory;


import org.ejaeger.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

}
