package com.yixihan.random.day0710;

/**
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 * <p>
 * 另给你一个整数链表的头节点 head 。
 * <p>
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。
 * 如果还存在剩余的空格，则用 -1 填充。
 * <p>
 * 返回生成的矩阵。
 * <p>
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 * 解释：上图展示了链表中的整数在矩阵中是如何排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 * <p>
 * 输入：m = 1, n = 4, head = [0,1,2]
 * 输出：[[0,1,2,-1]]
 * 解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 *
 * @author : yixihan
 * @create : 2022-07-10-9:18
 */
public class SpiralMatrix {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;
        ListNode node = head;

        while (true) {
            for (int i = l; i <= r; i++) {
                if (node != null) {
                    matrix[t][i] = node.val;
                    node = node.next;
                } else {
                    matrix[t][i] = -1;
                }
            }
            if (t++ >= b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                if (node != null) {
                    matrix[i][r] = node.val;
                    node = node.next;
                } else {
                    matrix[i][r] = -1;
                }
            }
            if (r-- <= l) {
                break;
            }

            for (int i = r; i >= l; i--) {
                if (node != null) {
                    matrix[b][i] = node.val;
                    node = node.next;
                } else {
                    matrix[b][i] = -1;
                }
            }
            if (b-- <= t) {
                break;
            }

            for (int i = b; i >= t; i--) {
                if (node != null) {
                    matrix[i][l] = node.val;
                    node = node.next;
                } else {
                    matrix[i][l] = -1;
                }
            }
            if (l++ >= r) {
                break;
            }
        }

        return matrix;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
