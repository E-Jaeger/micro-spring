package org.ejaeger.springframework.context.support;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.config.BeanPostProcessor;
import org.ejaeger.springframework.context.ApplicationContext;
import org.ejaeger.springframework.context.ApplicationContextAware;

/**
 * Created by zyp on 2021/12/10 5:51 下午
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
