package com.company.singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private Collection<String> list;

    private ThreadSafeSingleton() {
        list = new ArrayList<>();
//        list = new CopyOnWriteArrayList<>();
    }

    synchronized public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public Collection<String> getCopyListVariant() {
        return new CopyOnWriteArrayList<>(list);
    }

    public boolean add(String object) {
        synchronized (this) {
            return list.add(object);
        }
    }

    public boolean remove(String object) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().contentEquals(object)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
