package com.lizza.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MedianFinder {

    List<Integer> list;
    int sum;

    public MedianFinder() {
        list = new ArrayList<>();
        sum = 0;
    }

    public void addNum(int num) {
        list.add(num);
        sum += num;
    }

    public double findMedian() {
        if ((list.size() & 1) == 0) {
            return sum / 2.0d;
        } else {
            return list.get(list.size() >> 1);
        }
    }

    @Test
    public void test1() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());
    }
}
