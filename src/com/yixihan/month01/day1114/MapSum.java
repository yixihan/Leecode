package com.yixihan.month01.day1114;

/**
 *
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 * @author : yixihan
 * @create : 2021-11-14-13:40
 */
public class MapSum {

    private CustomMap[] maps;

    private int count;

    public MapSum() {
        maps = new CustomMap[1024];
        count = 0;
    }

    public void insert(String key, int val) {

        int index = isExist(key);

        if (index == -1) {
            CustomMap map = new CustomMap(key, val);
            maps[count++] = map;
        } else {
            maps[index].setValue(val);
        }
    }

    public int sum(String prefix) {

        int sum = 0;

        for (int i = 0; i < count; i++) {

            if (maps[i].getKey().startsWith(prefix)) {
                sum += maps[i].getValue();
            }
        }

        return sum;
    }

    private int isExist (String key) {

        if (isEmpty()) {
            return -1;
        }

        for (int i = 0; i < count; i++) {
            if (maps[i].getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty () {
        return count == 0;
    }
}

class CustomMap {

    private String key;

    private int value;


    public CustomMap() {
    }


    public CustomMap(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
