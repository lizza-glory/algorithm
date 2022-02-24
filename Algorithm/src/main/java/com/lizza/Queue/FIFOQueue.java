package com.lizza.Queue;

/**
 * 利用数组实现一个 FIFO 的队列
 * 要求: 避免数组 copy
 */
public class FIFOQueue {

    public static void main(String[] args){
        Queue queue = new Queue(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        System.out.println(queue.add(4));
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.add(3));
        System.out.println(queue.add(4));
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }

    static class Queue {
        private int size = 0;
        private int addIdx = 0;
        private int getIdx = 0;
        private int capacity;
        private Object[] array;

        public Queue (int capacity) {
            this.capacity = capacity;
            this.array = new Object[capacity];
        }

        public boolean add(Object e) {
            if (this.size < this.capacity) {
                array[addIdx++] = e;
                size++;
                if (this.addIdx == this.capacity) {
                    this.addIdx = 0;
                }
                return true;
            }
            return false;
        }

        public Object get() {
            if (this.size > 0) {
                if (this.getIdx == this.capacity) {
                    this.getIdx = 0;
                }
                this.size--;
                return array[getIdx++];
            }
            return null;
        }
    }
}
