package org.ejaeger.springframework.beans.factory;

/**
 * Created by zyp on 2021/12/3 6:52 下午
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
