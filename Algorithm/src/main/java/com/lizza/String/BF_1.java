package com.lizza.String;

import org.junit.Test;

/**
 * @Desc: BF 算法计算子串的位置(https://jqz3pp5nv2.feishu.cn/docs/doccnb1WIrbqFSXdruT3Iepe4Nb#)
 * 题目:
 * 设目标串 S=ababaca, 模式串: T=bac, 求 T 在 S 中首次出现的位置
 * 解法:
 * 从第一个字符开始同时遍历 S, T 中的每一个字符; 如果相等, 两个指针同时
 * 向后移动一位; 如果不相等, T, S 的指针重置
 * 结束标志:
 * T 的指针指向了最后一位
 * @author: lizza.liu
 * @date: 2021-10-17
 */
public class BF_1 {

    @Test
    public void test1() {
        char[] S = "ababaca".toCharArray();
        char[] T = "bac".toCharArray();
        int index = indexOf(S, T);
        System.out.println(index);
    }

    private int indexOf(char[] S, char[] T) {
        // 定义 S, T 的指针
        int s = 0, t = 0;
        // 结束条件: t 指向 T 最后的位置或 s 指向了 S 的最后的位置
        while (s < S.length && t < T.length) {
            // 如果相等, s, t 向后移动一位
            if (S[s] == T[t]) {
                s++;
                t++;
            } else {
                // 不相等, s 回到上一次位置后的那个位置, t 回到首位
                s = s - t + 1;
                t = 0;
            }
        }

        if (t >= T.length) {
            return (s - T.length);
        } else {
            return -1;
        }
    }

    @Test
    public void test2() throws Exception {

    }
}
