package com.lizza.v2.hash;

import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, count = 0, length = p.length();
        for (char c : p.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        while (i < s.length() && j < s.length()) {
            if (map.containsKey(s.charAt(j++))) {
                count++;
            } else {
                count = 0;
                i = j;
            }
            if (count == length) {
                result.add(i);
                i = j;
                count = 0;
            }
        }

        return result;
    }

    @Test
    public void test1() throws Exception {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
