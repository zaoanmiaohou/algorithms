package com.cathy.algorithms.demo;

/**
 * description
 *
 * @user cathy
 * @date 2019-11-18 19:05:11
 */
public class GreatestCommonDivisible {

    /**
     * 使用暴力枚举法求出最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int getGreatestCommonDivisible01(int a, int b){
        int big = a;
        int small = b;
        if (big % small == 0){
            return small;
        }
        for (int i = small/2; i >1; i--){
            if (big % i == 0 && small % i == 0){
                return i;
            }
        }
        return 1;
    }

    /**
     * 使用辗转相除法求出最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int getGreatestCommonDivisible02(int a, int b){
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0){
            return small;
        }
        return getGreatestCommonDivisible02(big/small, small);
    }

    /**
     * 使用更相减损术求出最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int getGreatestCommonDivisible03(int a, int b){

        if (a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisible03(big-small, small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisible01(25, 5));
        System.out.println(getGreatestCommonDivisible02(100, 10));
        System.out.println(getGreatestCommonDivisible03(27, 14));
    }
}