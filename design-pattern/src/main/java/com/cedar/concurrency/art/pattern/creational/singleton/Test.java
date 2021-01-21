package com.cedar.concurrency.art.pattern.creational.singleton;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangnan
 * @date 2020-04-11 11:40
 * @description
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazySingleton lazySingleton = LazySingleton.getInstance();


//        Thread t1 = new Thread(new T());
//        Thread t2 = new Thread(new T());
//        t1.start();
//        t2.start();
//        System.out.println("Program end");

//        HungrySingleton instance = HungrySingleton.getInstance();
        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);
        File file = new File("singleton_file");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        HungrySingleton instanceNew = (HungrySingleton) ois.readObject();
        EnumInstance instanceNew = (EnumInstance) ois.readObject();

        System.out.println(instance.getData());
        System.out.println(instanceNew.getData());
        System.out.println(instance.getData() == instanceNew.getData());

//        Class clazz = HungrySingleton.class;
//        Constructor constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        HungrySingleton instance = HungrySingleton.getInstance();
//
//        HungrySingleton instanceNew = (HungrySingleton) constructor.newInstance();
//
//        System.out.println(instance);
//        System.out.println(instanceNew);
//        System.out.println(instance == instanceNew);

    }

}
