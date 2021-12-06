package org.ejaeger.springframework.beans.factory;

/**
 * Created by zyp on 2021/12/3 6:49 下午
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
