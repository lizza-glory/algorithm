package com.lizza.v1.String;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2020-12-30
 */
public class MultiplyString {

    public static void main(String[] args){
        String num1 = "123";
        String num2 = "134";
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = arr1.length - 1; i >= 0; i--){
            for (int j = arr2.length - 1; j >= 0; j--) {

            }
        }
        for (char ch1 : num1.toCharArray()) {
            for (char ch2 : num2.toCharArray()) {
                System.out.println((ch1 - '0') * (ch2 - '0'));
            }
        }
    }
}
