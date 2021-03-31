package com.cedar.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangnan
 * @date 2021/3/10 9:41
 */
public class HashMapTest {


    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        String put = map.put("11111", "11111111");
        String put1 = map.put("11111", "11111111111111111");

        String value = map.get("11111");

        System.out.println("put: " + put + " put1: " + put1 + " value: " + value);


    }
}
