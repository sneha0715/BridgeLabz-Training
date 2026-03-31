package com.example;

public class StringUtils {

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
