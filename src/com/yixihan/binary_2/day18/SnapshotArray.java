package com.yixihan.binary_2.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 实现支持下列接口的「快照数组」-SnapshotArray：
 * <p>
 * SnapshotArray(int length)- 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于0。
 * void set(index, val)- 会将指定索引index处的元素设置为val。
 * int snap()- 获取该数组的快照，并返回快照的编号snap_id（快照号是调用snap()的总次数减去1）。
 * int get(index, snap_id)- 根据指定的snap_id选择快照，并返回该快照指定索引 index的值。
 * <p>
 * 示例：
 * <p>
 * 输入：["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 *
 * @author : yixihan
 * @create : 2022-05-26-19:25
 */
public class SnapshotArray {

    List<TreeMap<Integer, Integer>> list;
    int snap = 0;

    public SnapshotArray(int length) {
        list = new ArrayList<> ();

        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<> ();
            map.put (0, 0);
            list.add (map);
        }
    }

    public void set(int index, int val) {
        list.get (index).put (snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snap_id) {
        return list.get (index).floorEntry (snap_id).getValue ();
    }
}
