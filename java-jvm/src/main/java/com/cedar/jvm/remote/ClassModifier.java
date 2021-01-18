package com.cedar.jvm.remote;

/**
 * @author zhangnan
 * @date 2021/1/12 14:11
 */
public class ClassModifier {

    /**
     * 常量池的起始偏移
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * constant_utf8_info 敞亮tag的标志
     */
    private static final int CONSTANT_UTF8_INFO = 1;


    /**
     * 常量池中11中常亮所占的长度，constant_utf8_info 常量型除外，因为它不是定长的
     */
    private static final int[] constant_item_length = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};


    private static final int u1 = 1;

    private static final int u2 = 2;


    private byte[] classByte;


    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }


    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        return null;
    }


}
