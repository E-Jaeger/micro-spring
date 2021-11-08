package org.ejaeger.springframework.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
