package org.ejaeger.springframework.beans.factory.config;

import org.ejaeger.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * Created by zyp on 2021/11/29 3:27 下午
 */
public interface ConfigurableBeanFactory extends SingletonBeanRegistry, HierarchicalBeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
