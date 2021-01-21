package com.cedar.concurrency.art.pattern.creational.prototype;

import java.text.MessageFormat;

/**
 * @author zhangnan
 * @date 2020-04-12 17:15
 * @description 原型模式 深克隆与浅克隆 序列化与反序列化
 */
public class MailUtil {

    public static void sendMail(Mail mail) {
        String outPutContent = "向{0}同学，邮件地址：{1}，邮件内容：{2}发送邮件成功";

        System.out.println(MessageFormat.format(outPutContent, mail.getName(), mail.getEmailAddress(), mail.getContent()));

    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("存储originMail记录，originMail:" + mail.getContent());
    }
}
