package com.yixihan.programming_ability_2.day18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个嵌套的整数列表 nestedList 。
 * 每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。
 * 请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * <p>
 * 实现扁平迭代器类 NestedIterator ：
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 * <p>
 * 输入：nestedList = [[1,1],2,[1,1]]
 * 输出：[1,1,2,1,1]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 输入：nestedList = [1,[4,[6]]]
 * 输出：[1,4,6]
 * 解释：通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * @author : yixihan
 * @create : 2022-04-09-13:07
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> ans;

    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new ArrayList<> ();
        getVal (nestedList);
    }

    private void getVal(List<NestedInteger> list) {

        while (!list.isEmpty ()) {
            NestedInteger val = list.remove (0);
            if (val.isInteger ()) {
                ans.add (val.getInteger ());
            } else {
                List<NestedInteger> nestedIntegers = val.getList ();
                getVal (nestedIntegers);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext ()) {
            return ans.remove (0);
        }

        return null;
    }

    @Override
    public boolean hasNext() {
        return !ans.isEmpty ();
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
