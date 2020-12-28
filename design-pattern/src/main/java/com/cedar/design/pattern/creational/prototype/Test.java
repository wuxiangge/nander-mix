package com.cedar.design.pattern.creational.prototype;

import com.cedar.design.pattern.creational.singleton.HungrySingleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhangnan
 * @date 2020-04-12 17:22
 * @description
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for (int i = 0; i < 10; i++) {
            Mail tempMail = (Mail) mail.clone();
            tempMail.setName("姓名" + i);
            tempMail.setEmailAddress("姓名" + i + "@cumt.edu.cn");
            tempMail.setContent("恭喜你被我校录取");
            MailUtil.sendMail(tempMail);
        }
        MailUtil.saveOriginMailRecord(mail);


        // 深克隆测试
        Pig pig = new Pig();
        pig.setUpdateList(Arrays.asList(new Date()));
        System.out.println(pig.getUpdateList());


        Pig clonePig = pig.clone();
        System.out.println(clonePig.getUpdateList());

        clonePig.setUpdateList(Arrays.asList(new Date(2020)));
        System.out.println(pig.getUpdateList());
        System.out.println(clonePig.getUpdateList());


        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        Method cloneMethod = hungrySingleton.getClass().getDeclaredMethod("clone");
        cloneMethod.setAccessible(true);
        HungrySingleton cloneSingleton = (HungrySingleton) cloneMethod.invoke(hungrySingleton);

        System.out.println(hungrySingleton);
        System.out.println(cloneSingleton);

    }
}
