package com.cedar.concurrency.art.pattern.creational.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangnan
 * @date 2020-04-11 16:52
 * @description
 */
public class ContainerSingleton {

    private ContainerSingleton() {
    }

    private static Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    public static void putInstance(String key, Object instance) {
        if (StringUtils.isNoneBlank(key) && instance != null) {
            if (!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }


    public static Object getInstance(String key) {
        return singletonMap.get(key);
    }
}
