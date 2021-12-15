package org.ejaeger.springframework.beans.factory.support;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.DisposableBean;
import org.ejaeger.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * Created by zyp on 2021/12/6 11:13 上午
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        if (destroyMethodName != null && !destroyMethodName.equals("") && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (method == null) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }

    }
}
