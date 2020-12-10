package com.company.iterator;

import java.util.Iterator;

//0->1->2->4 result 2,4
public class TestIterator {
    public static class MyIterator implements Iterator {
        private int[] array;
        private int current;
        public MyIterator(int[] array) {
            this.array = array;
            this.current = 0;
        }
        @Override
        public boolean hasNext() {
            for (int i = current; i < array.length; i++) {
                if (array[i] % 2 == 0 && array[i] != 0) {
                    current = i;
                    return true;
                }
            }
            return false;
        }
        @Override
        public Object next() {
            if (hasNext()) {
                return array[current++];
            }
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 4};
        MyIterator myIterator = new MyIterator(array);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}
