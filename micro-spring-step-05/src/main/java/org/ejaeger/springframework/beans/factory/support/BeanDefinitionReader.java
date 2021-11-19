package org.ejaeger.springframework.beans.factory.support;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.core.io.Resource;
import org.ejaeger.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
