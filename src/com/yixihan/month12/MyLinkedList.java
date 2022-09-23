package com.yixihan.month12;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * 如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * @author : yixihan
 * @date : 2022-09-23-9:05
 */
public class MyLinkedList {

    Node head;
    int cnt;

    public MyLinkedList() {
        head = new Node ();
        cnt = 0;
    }

    public int get(int index) {
        if (index < 0 || index > cnt) {
            return -1;
        }

        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        addAtIndex (0, val);
    }

    public void addAtTail(int val) {
        addAtIndex (cnt, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > cnt) {
            return;
        }
        cnt++;
        Node node = head.next;
        if (index == 0) {
            head.next = new Node (val, node);
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node next = node.next;
        node.next = new Node (val, next);

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > cnt) {
            return;
        }
        Node node = head.next;
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = node;
            node = node.next;
        }
        pre.next = node.next;
        cnt--;
    }

    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/*
class MyLinkedList {

    Node root;
    int size;

    public MyLinkedList() {
        root = new Node ();
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node node = root;
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

        Node node = root;
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

        Node node = root;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        node.next = node.next.next;
    }

    class Node {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
        }

        public Node () {

        }
    }
}
 */
