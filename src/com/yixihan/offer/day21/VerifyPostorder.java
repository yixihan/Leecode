package com.yixihan.offer.day21;

/**
 * @author : yixihan
 * @create : 2022-03-12-11:29
 */
public class VerifyPostorder {

    /**
     * 从任意一个结点k往左的这个子数组，比k大的都在右边，比k小的都在左边 [ [...<k...] [...>k...] k]
     * 思路 : 从左往右迭代, 依次成为当前结点
     * 从当前节点往左看, 碰到比它小的后, 就不能碰到比它大的
     */
    public boolean verifyPostorder(int[] postorder) {

        boolean flag = false;
        for (int i = 0; i < postorder.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (postorder[j] < postorder[i]) {
                    // 出现了比当前小的
                    flag = true;
                }
                // 出现了比当前结点大的且之前已经出现了比当前结点小的
                if (flag && postorder[j] > postorder[i]) {
                    return false;
                }
            }
            flag = false;
        }
        return true;
    }
}
