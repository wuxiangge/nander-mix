package com.cedar.design.pattern.creational.singleton;

/**
 * @author zhangnan
 * @date 2020-04-11 13:38
 * @description
 */
public enum EnumInstance {

    INSTANCE {
        @Override
        public void printInfo() {
            System.out.println("测试反编译");
        }
    };

    public abstract void printInfo();

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }

}
