package org.ejaeger.springframework.test.bean;

import org.ejaeger.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyp on 2021/12/15 3:22 下午
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Map<String, String> hashMap = new HashMap<>();
                hashMap.put("10001", "胡桃");
                hashMap.put("10002", "钟离");
                hashMap.put("10003", "行秋");
                return "你被代理了 " + method.getName() + "：" + hashMap.get(args[0].toString());
            }
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
