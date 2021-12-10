package org.ejaeger.springframework.beans.factory;

/**
 * Created by zyp on 2021/12/10 5:39 下午
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
