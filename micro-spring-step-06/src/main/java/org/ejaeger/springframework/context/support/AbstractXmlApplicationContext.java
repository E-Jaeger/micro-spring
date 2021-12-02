package org.ejaeger.springframework.context.support;

import org.ejaeger.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.ejaeger.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Created by zyp on 2021/11/30 2:06 下午
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] locations = getConfigLocations();
        if (locations != null) {
            reader.loadBeanDefinitions(locations);
        }
    }

    protected abstract String[] getConfigLocations();
}
