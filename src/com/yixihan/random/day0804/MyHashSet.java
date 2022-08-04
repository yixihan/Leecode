package com.yixihan.random.day0804;

import org.w3c.dom.Node;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 *
 * @author : yixihan
 * @create : 2022-08-04-9:52
 */
public class MyHashSet {

    Node root;

    public MyHashSet() {
        root = new Node (-1);
    }

    public void add(int key) {
        Node node = root;

        while (node.next != null) {
            if (node.next.key == key) {
                return;
            }
            node = node.next;
        }
        node.next = new Node (key);
    }

    public void remove(int key) {
        Node node = root;
        show ();
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        show ();
    }

    public boolean contains(int key) {
        Node node = root;

        while (node != null) {
            if (node.key == key) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    private void show () {
        Node node = root;

        while (node != null) {
            System.out.print (node.key + " -> ");
            node = node.next;
        }

        System.out.println ();
    }

    class Node {
        int key;
        Node next;

        public Node() {
        }

        public Node(int key) {
            this.key = key;
        }
    }
}
