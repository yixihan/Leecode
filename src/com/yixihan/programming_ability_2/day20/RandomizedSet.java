package com.yixihan.programming_ability_2.day20;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。
 * 每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * <p>
 * 输入
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * 解释
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
 * randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
 * randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
 * randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 *
 * @author : yixihan
 * @create : 2022-04-11-14:42
 */
public class RandomizedSet {

    Set<Integer> set;
    List<Integer> list;
    Random random = new Random ();

    public RandomizedSet() {
        set = new HashSet<> ();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean add = set.add (val);
        if (add) {
            list.clear ();
        }
        return add;
    }

    public boolean remove(int val) {
        boolean remove = set.remove (val);
        if (remove) {
            list.clear ();
        }
        return remove;
    }

    public int getRandom() {
        set.forEach (System.out::println);
        if (list.isEmpty ()) {
            list = new ArrayList<> (set);
        }
        return list.get (random.nextInt (list.size ()));
    }
}
