package com.cathy.algorithms.demo;

import java.util.Stack;

/**
 * description
 *
 * @user cathy
 * @date 2019-11-18 19:05:42
 */
public class ImplementQueueUsingStacks {


    private static Stack<Integer> stackA = new Stack<Integer>();
    private static Stack<Integer> stackB = new Stack<Integer>();

    /**
     * 从队列中取出一个元素
     * @return
     */
    private static Integer get(){
        if (stackB.empty()){
            while (stackA.size() != 0){
                stackB.push(stackA.pop());
            }
        }
        if (stackB.peek() != null){
            return stackB.pop();
        } else {
            return null;
        }
    }

    /**
     * 向队列中放一个元素
     * @param i
     */
    private static void put(Integer i){
        stackA.push(i);
    }

    public static void main(String[] args) {
        put(1);
        put(2);
        System.out.println(get());
        put(3);
        System.out.println(get());
        put(4);
        put(5);
        System.out.println(get());
        System.out.println(get());
        put(6);
        System.out.println(get());
        System.out.println(get());
    }
}