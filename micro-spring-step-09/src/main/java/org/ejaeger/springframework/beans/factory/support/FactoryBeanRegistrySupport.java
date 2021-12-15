package org.ejaeger.springframework.beans.factory.support;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static sun.tools.jconsole.inspector.XObject.NULL_OBJECT;

/**
 * Created by zyp on 2021/12/14 3:28 下午
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryObjectBeanCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectFromFactoryBean(String beanName) {
        Object o = this.factoryObjectBeanCache.get(beanName);
        return o != NULL_OBJECT ? o : null;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = getCachedObjectFromFactoryBean(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryObjectBeanCache.put(beanName, object != null ? object : NULL_OBJECT);
            }
            return object != NULL_OBJECT ? object : null;
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(FactoryBean factory, String beanName) {
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }

}
