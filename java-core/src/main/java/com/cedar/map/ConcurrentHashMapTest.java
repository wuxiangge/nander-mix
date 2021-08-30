package com.cedar.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangnan
 * @date 2021/8/25
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("111", "1111");
    }
}
