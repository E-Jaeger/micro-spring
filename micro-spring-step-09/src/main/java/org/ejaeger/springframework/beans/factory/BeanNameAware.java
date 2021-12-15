package org.ejaeger.springframework.beans.factory;

/**
 * Created by zyp on 2021/12/10 5:41 下午
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
