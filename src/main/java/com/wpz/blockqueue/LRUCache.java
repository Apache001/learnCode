package com.wpz.blockqueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 添加说明记得一定要大于十个字符
 *
 * @author wangpengzhe
 * @date 2020/3/15 20:58
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class LRUCache {

    Deque<Integer> deque = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            deque.remove(key);
            deque.offerFirst(key);
            return map.get(key);
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key);
        } else {
            if(capacity <= map.size()){
                Integer last = deque.pollLast();
                map.remove(last);
            }
        }
        deque.offerFirst(key);
        map.put(key, value);
    }

}
