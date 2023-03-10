package com.lizza.Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * 参考: https://www.bilibili.com/video/BV1cy4y167mM/?spm_id_from=333.999.0.0&vd_source=b4974145db4a002a60536830f7890e47
 *
 * 思路:
 * 1. 回溯 + 剪枝
 */
public class Permutation {

    char[] array = new char[]{'a', 'a', 'c'};

    List<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        array = s.toCharArray();
        dfs(array.length, 0);
        return result.toArray(new String[0]);
    }

    public void dfs(int length, int x) {
        if (x == length - 1) {
            result.add(String.valueOf(array));
            return;
        }

        Set<Character> set = new HashSet<>(length);
        for (int i = x; i < array.length; i++) {
            if (set.contains(array[i])) {
                continue;
            }
            set.add(array[i]);
            swap(i, x);
            dfs(length, x + 1);
            swap(x, i);
        }
    }

    public void swap(int i, int x) {
        char ch = array[i];
        array[i] = array[x];
        array[x] = ch;
    }

    @Test
    public void test1() throws Exception {
        dfs(array.length, 0);
        System.out.println(result);
    }
}
