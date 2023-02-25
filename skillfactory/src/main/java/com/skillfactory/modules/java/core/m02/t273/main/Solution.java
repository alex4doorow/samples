package com.skillfactory.modules.java.core.m02.t273.main;

public class Solution {
    int a;
    int b;
    int c;
    int d;
    public void max(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        // write your code here
    }

    public int findMaximum() {
/*
        Integer[] sourceArray = { a, b, c, d };
        List<Integer> values = Arrays.asList(sourceArray);
        return Collections.max(values);
*/
        int result = 0;
        if (a > b) {
            result = a;
        } else {
            result = b;
        }
        if (result < c) {
            result = c;
        }
        if (result < d) {
            result = d;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaximum());
    }

}

