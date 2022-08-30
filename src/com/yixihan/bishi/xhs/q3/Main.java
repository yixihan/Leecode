package com.yixihan.bishi.xhs.q3;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-08-28-15:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<> (n);
        for (int i = 1; i < n; i++) {
            int tmp = sc.nextInt ();
            List<Integer> list1 = map.getOrDefault (tmp, new ArrayList<> ());
            list1.add (i + 1);
            map.put (tmp, list1);

            List<Integer> list2 = map.getOrDefault (i + 1, new ArrayList<> ());
            list2.add (tmp);
            map.put (i + 1, list2);
        }
        PriorityQueue<Node> queue = new PriorityQueue<> (Comparator.comparingInt (o -> o.list.size ()));
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet ()) {
            queue.add (new Node (entry.getKey (), entry.getValue ()));
        }

        int ans = 0;
        while (!queue.isEmpty ()) {
            Node node = queue.poll ();
            if (visited[node.index - 1]) {
                continue;
            }
            for (int val : node.list) {
                if (!visited[val - 1]) {
                    visited[val - 1] = true;
                    visited[node.index - 1] = true;
                    ans++;
                    break;
                }
            }
        }

        System.out.println (ans);


    }

    static class Node {
        int index;
        List<Integer> list;

        public Node(int index, List<Integer> list) {
            this.index = index;
            this.list = list;
        }

    }
}

/*
1 => 2
4 => 2
5 => 3
6 => 3
2 => 1, 3, 4
3 => 2, 5, 6

 */