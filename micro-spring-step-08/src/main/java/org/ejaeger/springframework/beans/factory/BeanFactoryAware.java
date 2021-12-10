package org.ejaeger.springframework.beans.factory;

import org.ejaeger.springframework.beans.BeansException;

/**
 * Created by zyp on 2021/12/10 5:02 下午
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
