package com.wpz.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/2/27 10:58
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class LRUCache<K,V> extends LinkedHashMap<K, V> {

    private int CACHE_SIZE = 3;

    public LRUCache(){
        super(16, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache<Integer,Integer> cache = new LRUCache<>();
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
       // cache.put(4,4);

        System.out.println(cache);
        cache.get(1);
        cache.put(4, 4);
        System.out.println(cache.keySet());


    }
}
