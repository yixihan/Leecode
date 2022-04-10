package com.yixihan.programming_ability_2.day19;

/**
 * @author : yixihan
 * @create : 2022-04-10-15:06
 */
public class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = new Node ();
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node node = head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }

        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex (0, val);
    }

    public void addAtTail(int val) {
        addAtIndex (size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }
        size++;

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        Node newNode = new Node (val);
        newNode.next = node.next;
        node.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        node.next = node.next.next;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {

        }
    }
}
