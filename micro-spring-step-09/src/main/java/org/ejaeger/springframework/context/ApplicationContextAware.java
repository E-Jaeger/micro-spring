package org.ejaeger.springframework.context;

import org.ejaeger.springframework.beans.BeansException;
import org.ejaeger.springframework.beans.factory.Aware;

/**
 * Created by zyp on 2021/12/10 5:47 下午
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
