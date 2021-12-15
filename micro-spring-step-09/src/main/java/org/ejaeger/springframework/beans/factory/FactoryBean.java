package org.ejaeger.springframework.beans.factory;

/**
 * Created by zyp on 2021/12/14 3:20 下午
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
