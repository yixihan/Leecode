package com.yixihan.bishi.meituan.q3;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-08-06-9:59
 */
public class Main {

    static Map<Integer, Set<Node>> map = new HashMap<> ();
    static int half;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        half = n % 2 == 0 ? n / 2 : n / 2 + 1;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node ();
            nodes[i].index = i;
            nodes[i].num1 = sc.nextInt ();
        }
        for (int i = 0; i < n; i++) {
            nodes[i].num2 = sc.nextInt ();
        }

        helper (nodes);

        List<Integer> keys = new ArrayList<> ();
        for (Map.Entry<Integer, Set<Node>> entry : map.entrySet ()) {
            if (entry.getValue ().size () >= half) {
                keys.add (entry.getKey ());
            }
        }

        int min = Integer.MAX_VALUE;
        for (int key : keys) {
            min = Math.min (min, getMin (map.get (key), key));
        }

        System.out.println (min == Integer.MAX_VALUE ? -1 : min);

    }

    private static int getMin(Set<Node> nodes, int key) {
        int z = 0;
        int canZ = 0;
        int f = 0;
        int canF = 0;

        for (Node node : nodes) {
            if (node.num1 == key && node.num2 == key) {
                z++;
                f++;
                continue;
            }
            if (node.num1 == key) {
                z++;
                canF++;
            } else if (node.num2 == key) {
                f++;
                canZ++;
            }
        }

        if (z >= half || f >= half) {
            return 0;
        } else {
            if (z + canZ >= half && f + canF >= half) {
                return Math.min (canF, canZ);
            } else if (z + canZ >= half) {
                return canZ;
            } else if (f + canF >= half) {
                return canF;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    private static void helper(Node[] nodes) {
        for (Node node : nodes) {
            Set<Node> set1 = map.getOrDefault (node.num1, new HashSet<> ());
            set1.add (node);
            map.put (node.num1, set1);

            Set<Node> set2 = map.getOrDefault (node.num2, new HashSet<> ());
            set2.add (node);
            map.put (node.num2, set2);
        }
    }

    static class Node {
        int num1;
        int num2;
        int index;

        public Node() {
        }

        public Node(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public String toString() {
            return "Node{" + "num1=" + num1 + ", num2=" + num2 + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return num1 == node.num1 && num2 == node.num2;
        }

        @Override
        public int hashCode() {
            return Objects.hash (num1, num2);
        }
    }
}
