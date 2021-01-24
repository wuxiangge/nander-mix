package com.cedar.jvm.remote;

/**
 * 为了多次载入执行类而加入的加载器
 * 把 defineClass 方法开发出来 只有外部显示调用电脑时候才会使用到loadByte方法
 * <p>
 * 由虚拟机调用时 仍然按照原来的双亲委派规则使用loadClass方法进行类加载
 */
public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }


    public Class loadBytes(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }


}
