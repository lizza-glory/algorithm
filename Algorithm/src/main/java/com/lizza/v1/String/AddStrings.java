package com.lizza.v1.String;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），
 * 也不能直接将输入的字符串转换为整数形式。
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 * 链接：https://leetcode-cn.com/problems/add-strings
 *
 * 思路:
 * 1. 将字符串转为 char 数组, 从低位开始相加, 超过 10 的进位
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        StringBuffer result = new StringBuffer();

        while (i >= 0 || j >= 0) {
            int ch1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int ch2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int s = ch1 + ch2 + carry;
            // 如果 s 对 10 做除法, 大于 0 说明应该进位
            carry = s / 10;
            result.append(s % 10);
            i--;
            j--;
        }
        // 如果最后一轮遍历 carry 是 1 说明应该进位
        if (carry > 0) {
            result.append(1);
        }

        return result.reverse().toString();
    }


}
