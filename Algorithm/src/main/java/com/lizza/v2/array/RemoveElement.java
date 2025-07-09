package com.lizza.v2.array;

/**
 * 题目:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 *
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 *
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 *
 * 链接: https://leetcode.cn/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 解法:
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
