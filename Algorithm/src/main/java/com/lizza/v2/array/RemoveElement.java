package com.lizza.v2.array;

/**
 * 如果右指针指向的元素不等于 val，它一定是输出数组的一个元素，我们就将右指针指向的元素复制到左指针位置，
 * 然后将左右指针同时右移；
 *
 * 如果右指针指向的元素等于 val，它不能在输出数组里，此时左指针不动，右指针右移一位。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/remove-element/solutions/730203/yi-chu-yuan-su-by-leetcode-solution-svxi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j++];
            } else {
                j++;
            }
        }
        return i;
    }
}
