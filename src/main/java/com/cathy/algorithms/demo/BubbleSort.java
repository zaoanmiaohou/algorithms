package com.cathy.algorithms.demo;

/**
 * description
 *            冒泡排序
 * @user cathy
 * @date 2019-11-28 16:32:25
 */
public class BubbleSort {

    public static void main(String[] args) {
        int  byt[] = {1, 8, 4, 7, 11, 3, 9, 0};
        sort(byt);
    }

    private static void sort(int[] byt){
        for (int i = 0; i < byt.length; i++){
            int temp;
            for (int j = 0; j < byt.length - i - 1; j++){
                if (byt[j] < byt[j + 1]){
                    temp = byt[j];
                    byt[j] = byt[j + 1];
                    byt[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i <byt.length; i++){
            System.out.print(byt[i] + " ");
        }
    }
}
