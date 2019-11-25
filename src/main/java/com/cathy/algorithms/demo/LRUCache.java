package com.cathy.algorithms.demo;

import java.util.HashMap;

/**
 * description
 *     手写LRU算法
 *
 * @user cathy
 * @date 2019-11-24 12:41:31
 */
public class LRUCache {

    /** 限制的hashMap的长度 */
    int limit = 6;
    HashMap<String, Node> hashMap = new HashMap<>();

    Node head;
    Node end;

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache();
        lruCache.put(new Node("1", "11111"));
        lruCache.put(new Node("2", "22222"));
        lruCache.put(new Node("3", "33333"));
        lruCache.get("2");
        lruCache.put(new Node("5", "55555"));
        lruCache.put(new Node("3", "33333"));
        lruCache.put(new Node("4", "44444"));
        lruCache.put(new Node("6", "66666"));
        lruCache.get("5");
        lruCache.put(new Node("7", "77777"));
        lruCache.put(new Node("8", "88888"));
        lruCache.get("5");

    }

    /**
     * 用来打印node串
     * @return
     */
    private void printNode(){
        System.out.println();
        Node node = head;
        while(node != null){
            System.out.print(node.key);
            node = node.next;
        }
    }

    private void get(String key){
        Node node = hashMap.get(key);
        // 有该条数据
        // 将该对象从原有地方删除，并刷新到队尾
        removeNode(node);
        addNode(node);
        System.out.println();
        System.out.print("get----" + node.key);
        printNode();
    }

    private void put(Node node){
        // 存在该对象
        Node node1 = hashMap.get(node.key);
        if(node1 != null){
            // 将值刷新
            node1.value = node.value;
            if(node1 != end){
                // 将该对象从原有地方删除，并刷新到队尾
                removeNode(node1);
                addNode(node1);
            }
        } else {
            // 不存在该对象，将该对象放入队尾
            // 先查看hashMap的长度是否已经达到最大
            if(hashMap.size() >= limit){
                // 要删除hashMap的头元素，将新元素放入
                head = head.next;
                head.pre = null;

                end.next = node;
                end = node;
                end.next = null;

                // 直接将新node放入hashMap的尾巴
                addNode(node);
            } else {
                // 直接将新node放入hashMap的尾巴
                addNode(node);
            }
        }

        printNode();

    }

    /**
     * 新增节点，只用于增加尾节点
     */
    private void addNode(Node node) {
        if(end != null){
            // 原始有尾节点
            node.pre = end;
            end.next = node;
            end = node;
            end.next = null;
        } else {
            // 该hashMap里没有任何节点，直接将头节点和尾节点都设置为新的节点
            head = node;
            end = node;
        }
        hashMap.put(node.key, node);
    }

    /**
     * 用于原有存在节点的删除
     * @param node
     */
    private void removeNode(Node node){
        if(node == head && node == end){
            // 如果节点是第一个节点，则置头结点和尾节点为空
            head = null;
            end = null;
        } else if (node == head){
            // 如果是头节点，
            head = head.next;
            head.pre = null;
        } else if(node == end){
            // 如果是尾节点
            end = end.pre;
            end.next = null;
        } else {
            // 在中间
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        hashMap.remove(node.key);
    }
}

class Node{
    String key;
    String value;

    Node pre;
    Node next;

    Node(String key, String value){
        this.key = key;
        this.value = value;
    }
}
