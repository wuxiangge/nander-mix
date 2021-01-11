package com.cedar.jvm;

import java.io.Console;

public class TypeCaster {


    public static void main(String[] args) {
        int n = 123456789;
        float f = n;
        System.out.println(f);




        String str = "greeting";
        String substring = str.substring(0, 3);
        System.out.println(substring);
        int i = str.codePointCount(0, str.length());
        System.out.println(i);

        System.out.println(str.lastIndexOf("t"));

        System.out.println(str.substring(0,str.length()-1));

        System.out.println(str.toUpperCase());


        Console console = System.console();
//        String s = console.readLine("user name:");
//        char[] chars = console.readPassword("password:");

        String property = System.getProperty("user.dir");
        System.out.println(property);

    }
}
