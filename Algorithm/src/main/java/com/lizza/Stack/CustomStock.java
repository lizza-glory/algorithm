package com.lizza.Stack;

/**
 * 利用数组实现自定义的栈
 */
public class CustomStock {

    public static void main(String[] args){
    	Stack stack = new Stack(3);
    	System.out.println(stack.push(1));
    	System.out.println(stack.push(2));
    	System.out.println(stack.push(3));
    	System.out.println(stack.push(4));
    	System.out.println(stack.push(5));
    	System.out.println(stack.pop());
    	System.out.println(stack.pop());
    	System.out.println(stack.pop());
        System.out.println(stack.push(4));
        System.out.println(stack.push(5));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class Stack {
        Object[] data;
        int size;
        int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            this.data = new Object[capacity];
        }

        public boolean push(Object e) {
            if (size < capacity) {
                data[size++] = e;
                return true;
            }
            return false;
        }

        public Object pop() {
            if (size > 0) {
                return data[--size];
            }
            return null;
        }
    }
}
