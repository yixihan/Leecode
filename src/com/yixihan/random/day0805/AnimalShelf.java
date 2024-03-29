package com.yixihan.random.day0805;

import java.util.*;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。
 * 在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，
 * 或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。
 * 请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。
 * 允许使用Java内置的LinkedList数据结构。
 * <p>
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * <p>
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * <p>
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 *
 * @author : yixihan
 * @create : 2022-08-05-15:18
 */
public class AnimalShelf {

    Deque<int[]> dogQueue = new LinkedList<> ();
    Deque<int[]> catQueue = new LinkedList<> ();

    public AnimalShelf() {

    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            catQueue.addLast (animal);
        } else {
            dogQueue.addLast (animal);
        }
    }

    public int[] dequeueAny() {
        if (isCatQueueEmpty () && isDogQueueEmpty ()) {
            return new int[]{-1, -1};
        } else if (isDogQueueEmpty ()) {
            return catQueue.removeFirst ();
        } else if (isCatQueueEmpty ()){
            return dogQueue.removeFirst ();
        } else {
            int[] cat = catQueue.peekFirst ();
            int[] dog = dogQueue.peekFirst ();
            System.out.println (Arrays.toString (cat));
            System.out.println (Arrays.toString (dog));

            return cat[0] > dog[0] ? dogQueue.removeFirst () : catQueue.removeFirst ();
        }
    }

    public int[] dequeueDog() {
        if (isDogQueueEmpty ()) {
            return new int[]{-1, -1};
        }
        return dogQueue.removeFirst ();
    }

    public int[] dequeueCat() {
        if (isCatQueueEmpty ()) {
            return new int[]{-1, -1};
        }
        return catQueue.removeFirst ();
    }

    private boolean isDogQueueEmpty() {
        return dogQueue.isEmpty ();
    }

    private boolean isCatQueueEmpty() {
        return catQueue.isEmpty ();
    }
}
