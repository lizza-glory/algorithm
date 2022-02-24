package com.lizza.Search;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-12-28
 */
public class BinarySearch {

    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(array, 0, array.length - 1, 1));
    }

    public static int binarySearch(int[] array, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (target < array[mid])
            return binarySearch(array, start, mid - 1, target);
        if (target > array[mid])
            return binarySearch(array, mid + 1, end, target);

        return mid;
    }
}
