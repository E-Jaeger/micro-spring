package org.ejaeger.springframework.beans.factory.support;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.config.BeanDefinition;
import org.ejaeger.springframework.beans.factory.config.BeanPostProcessor;
import org.ejaeger.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.ejaeger.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> postProcessorList = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.postProcessorList.remove(beanPostProcessor);
        this.postProcessorList.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getPostProcessors() {
        return this.postProcessorList;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
