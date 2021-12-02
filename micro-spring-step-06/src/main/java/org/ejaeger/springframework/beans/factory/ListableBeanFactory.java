package org.ejaeger.springframework.beans.factory;

import org.ejaeger.springframework.beans.BeansException;

import java.util.Map;

/**
 * Created by zyp on 2021/11/29 3:01 下午
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;


    /**
     * 返回所有bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
