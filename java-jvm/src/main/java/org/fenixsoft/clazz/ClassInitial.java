package org.fenixsoft.clazz;

public class ClassInitial {


    public static int a = 1;

    public static int b = 0;

    public static ClassInitial instance = new ClassInitial();


    public ClassInitial() {
        a++;
        b++;
    }

}
