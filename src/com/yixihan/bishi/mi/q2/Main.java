package com.yixihan.bishi.mi.q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}

class Solution {

    List<Integer> list = new ArrayList<> ();

    /* Write Code Here */
    public Node Convert(Node pRootOfTree) {
        dfs (pRootOfTree);
        return create ();
    }

    private void dfs(Node node) {
        if (node.left != null) {
            dfs (node.left);
        }

        list.add (node.data);

        if (node.right!= null) {
            dfs (node.right);
        }
    }

    private Node create () {
        Node head = new Node ();
        Node node = head;

        for (Integer val : list) {
            node.right = new Node (val);
            node = node.right;
        }
        node = head.right;
        Node tmp = node.right;

        while (tmp.right != null) {
            tmp.left = node;
            node = tmp;
            tmp = tmp.right;
        }
        show (head.right);
        return head.right;
    }

    private void show (Node head) {
        Node node = head;

        while (node != null) {
            System.out.print (node + "==>");
            node = node.right;
        }
        System.out.println ();
    }
}

/**
 * @author : yixihan
 * @create : 2022-09-14-19:15
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        Node res = null;
        List<Node> list = new ArrayList<> ();

        while (in.hasNext ()) {
            int item = in.nextInt ();
            if (item == -1) {
                list.add (null);
            } else {
                list.add (new Node (item));
            }
        }
        int len = list.size ();
        int i = 0;
        while (i <= (len - 2) / 2) {
            if (2 * i + 1 < len && list.get (i) != null) {
                list.get (i).left = list.get (2 * i + 1);
            }
            if (2 * i + 2 < len && list.get (i) != null) {
                list.get (i).right = list.get (2 * i + 2);
            }
            i++;
        }

        res = new Solution ().Convert (list.get (0));
        if (res != null) {
            while (res.right != null && res.data != -1) {
                System.out.print (String.valueOf (res.data) + " ");
                res = res.right;
            }
            System.out.print (res.data + " ");
            while (res.left != null && res.data != -1) {
                System.out.print (String.valueOf (res.data) + " ");
                res = res.left;
            }
            System.out.print (res.data);
        }
        System.out.println ();
    }
}

