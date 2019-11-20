package com.cathy.algorithms.demo;

/**
 * description
 *              用数组实现大整数的相加
 * @user cathy
 * @date 2019-11-20 19:56:25
 */
public class BigNumberSum {

    public static void main(String[] args) {
        String result = bigNumberSum("1645", "856947");
        System.out.println(result);
    }

    /**
     * 数组实现大整数的相加
     * @param numberA
     * @param numberB
     * @return
     */
    private static String bigNumberSum(String numberA, String numberB) {
        // 用来计算数组的长度
        int maxLenght = numberA.length() > numberB.length() ? numberA.length() : numberB.length();
        // 存数组A的数据
        int[] byteA = new int[maxLenght + 1];
        // 存数组B的数据
        int[] byteB = new int[maxLenght + 1];

        // 结果数组
        int[] result = new int[maxLenght + 1];
        // 给数组A和数组B赋值
        for (int i = 0; i < numberA.length(); i++){
            byteA[i] = numberA.charAt(numberA.length() -1 - i) - '0';
        }
        for (int i = 0; i < numberB.length(); i++){
            byteB[i] = numberB.charAt(numberB.length() -1 - i) - '0';
        }

        // 开始做加法操作
        for (int i = 0; i < maxLenght; i++){
            int resultTemp = result[i] + byteA[i] + byteB[i];
            if(resultTemp >= 10){
                result[i + 1] = 1;
                result[i] = byteA[i] + byteB[i] - 10;
            } else {
                result[i] = resultTemp;
            }
        }

        StringBuilder sb = new StringBuilder();
        // 将result数组的结果打印出来，将数组反向打印出来
        for(int i = result.length - 1; i >= 0; i--){
            if (i == result.length - 1 && result[result.length - 1] == 0){
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }


}
