package com.yixihan.month10.day0815;

/**
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * <p>
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *
 * @author : yixihan
 * @create : 2022-08-15-8:28
 */
public class MyCircularDeque {

    int[] nums;
    int size;
    int cnt;
    int front;
    int rear;

    public MyCircularDeque(int k) {
        nums = new int[k];
        size = k;
        cnt = 0;
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull ()) {
            return false;
        }

        nums[front] = value;
        front = (front + 1) % size;
        cnt++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull ()) {
            return false;
        }

        rear = (rear + size - 1) % size;
        nums[rear] = value;
        cnt++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty ()) {
            return false;
        }

        front = (front + size - 1) % size;
        cnt--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty ()) {
            return false;
        }

        rear = (rear + 1) % size;
        cnt--;
        return true;
    }

    public int getFront() {
        if (isEmpty ()) {
            return -1;
        }

        return nums[(front - 1 + size) % size];
    }

    public int getRear() {
        if (isEmpty ()) {
            return -1;
        }

        return nums[rear];
    }

    public boolean isEmpty() {
        return cnt == 0;
    }

    public boolean isFull() {
        return cnt == size;
    }
}
