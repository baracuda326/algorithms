package com.company.twoqcache;

import java.util.List;
import java.util.Map;

public interface ITwoQ<K, V> {
    void resize(int maxSize);

    V get(K key);

    V put(K key, V value);

    V remove(K key);

    int size();

    int maxSize();

    int hitCount();

    int missCount();

    int createCount();

    int putCount();

    int evictionCount();

    Map<K, V> snapshot();

    List<Object> getMapHotSnapshot();
}
