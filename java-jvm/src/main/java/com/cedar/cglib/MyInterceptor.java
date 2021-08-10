package com.cedar.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangnan
 * @className MyInterceptor
 * @date 2021/8/9
 * @description //TODO
 */
public class MyInterceptor implements MethodInterceptor {
    public Object getProxy(Class<?> clzss) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clzss);
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName());
        System.out.println("事务开始。。。");
//		Object result = method.invoke(object, args); //死循环，内存溢出
//		Object result = methodProxy.invoke(object, args);//死循环，内存溢出
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("事务结束。。。");
        return result;
    }
}



