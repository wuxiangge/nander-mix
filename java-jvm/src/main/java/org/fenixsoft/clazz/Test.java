package org.fenixsoft.clazz;

public class Test {

    public static void main(String[] args) {
        System.out.println(ClassInitial.a);
        System.out.println(ClassInitial.b);

        ClassInitial classInitial = new ClassInitial();
        System.out.println(classInitial.a);
        System.out.println(classInitial.b);
    }
}
