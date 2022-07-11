package com.yixihan.random.day0711;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 *
 * @author : yixihan
 * @create : 2022-07-11-8:15
 */
public class SwapNumbers {

    /**
     * 步骤
     * 5 3  7 2
     * 8 3  9 2
     * 8 5  9 7
     * 3 5  2 7
     *
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {

        numbers[0] += numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] -= numbers[1];

        return numbers;
    }
}
