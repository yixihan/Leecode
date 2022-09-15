package com.yixihan.random.day0915;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 * @author : yixihan
 * @create : 2022-09-15-10:10
 */
public class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<> ();
        this.k = k;
        for (int num : nums) {
            add (num);
        }
    }

    public int add(int val) {
        queue.offer (val);
        if (queue.size () > k) {
            queue.poll ();
        }
        return queue.peek ();

    }
}
