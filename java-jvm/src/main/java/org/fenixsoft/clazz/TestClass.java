package org.fenixsoft.clazz;

public class TestClass {

    private int m;


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
