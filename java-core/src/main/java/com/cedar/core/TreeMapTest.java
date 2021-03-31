package com.cedar.core;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhangnan
 * @date 2021/3/10 10:19
 */
public class TreeMapTest {


    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();


        String put = map.put("1111", "11111111");
        String put1 = map.put("111", "111111111111111");

        System.out.println("put: " + put + " put1: " + put1);


    }


}
