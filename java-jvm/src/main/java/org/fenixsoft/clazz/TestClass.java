package org.fenixsoft.clazz;

public class TestClass {

    private int m;

    private static Integer nums;

    private static final Integer Num = 10;

    static {
        int a = 0;
        System.out.println(a);
        nums = 100;
    }

    private static TestClass testClass = new TestClass();

    public static TestClass getInstance() {
        return testClass;
    }


    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 4;
            return x;
        } finally {
            x = 9;
        }
    }

}
