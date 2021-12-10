package org.ejaeger.springframework.context;

import org.ejaeger.springframework.beans.BeansException;

/**
 * Created by zyp on 2021/11/29 5:27 下午
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}
