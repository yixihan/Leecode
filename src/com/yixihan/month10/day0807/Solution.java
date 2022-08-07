package com.yixihan.month10.day0807;

import org.w3c.dom.Node;

import java.util.List;
import java.util.Stack;

/**
 * 有一个 单线程 CPU 正在运行一个含有 n 道函数的程序。每道函数都有一个位于  0 和 n-1 之间的唯一标识符。
 * <p>
 * 函数调用 存储在一个 调用栈 上 ：当一个函数调用开始时，它的标识符将会推入栈中。
 * 而当一个函数调用结束时，它的标识符将会从栈中弹出。标识符位于栈顶的函数是 当前正在执行的函数 。
 * 每当一个函数开始或者结束时，将会记录一条日志，包括函数标识符、是开始还是结束、以及相应的时间戳。
 * <p>
 * 给你一个由日志组成的列表 logs ，其中 logs[i] 表示第 i 条日志消息，
 * 该消息是一个按 "{function_id}:{"start" | "end"}:{timestamp}" 进行格式化的字符串。
 * 例如，"0:start:3" 意味着标识符为 0 的函数调用在时间戳 3 的 起始开始执行 ；
 * 而 "1:end:2" 意味着标识符为 1 的函数调用在时间戳 2 的 末尾结束执行。
 * 注意，函数可以 调用多次，可能存在递归调用 。
 * <p>
 * 函数的 独占时间 定义是在这个函数在程序所有函数调用中执行时间的总和，调用其他函数花费的时间不算该函数的独占时间。
 * 例如，如果一个函数被调用两次，一次调用执行 2 单位时间，另一次调用执行 1 单位时间，那么该函数的 独占时间 为 2 + 1 = 3 。
 * <p>
 * 以数组形式返回每个函数的 独占时间 ，其中第 i 个下标对应的值表示标识符 i 的函数的独占时间。
 * <p>
 * 输入：n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * 输出：[3,4]
 * 解释：
 * 函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，于时间戳 1 的末尾结束执行。
 * 函数 1 在时间戳 2 的起始开始执行，执行 4 个单位时间，于时间戳 5 的末尾结束执行。
 * 函数 0 在时间戳 6 的开始恢复执行，执行 1 个单位时间。
 * 所以函数 0 总共执行 2 + 1 = 3 个单位时间，函数 1 总共执行 4 个单位时间。
 * <p>
 * 输入：n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
 * 输出：[8]
 * 解释：
 * 函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，并递归调用它自身。
 * 函数 0（递归调用）在时间戳 2 的起始开始执行，执行 4 个单位时间。
 * 函数 0（初始调用）恢复执行，并立刻再次调用它自身。
 * 函数 0（第二次递归调用）在时间戳 6 的起始开始执行，执行 1 个单位时间。
 * 函数 0（初始调用）在时间戳 7 的起始恢复执行，执行 1 个单位时间。
 * 所以函数 0 总共执行 2 + 4 + 1 + 1 = 8 个单位时间。
 * <p>
 * 输入：n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
 * 输出：[7,1]
 * 解释：
 * 函数 0 在时间戳 0 的起始开始执行，执行 2 个单位时间，并递归调用它自身。
 * 函数 0（递归调用）在时间戳 2 的起始开始执行，执行 4 个单位时间。
 * 函数 0（初始调用）恢复执行，并立刻调用函数 1 。
 * 函数 1在时间戳 6 的起始开始执行，执行 1 个单位时间，于时间戳 6 的末尾结束执行。
 * 函数 0（初始调用）在时间戳 7 的起始恢复执行，执行 1 个单位时间，于时间戳 7 的末尾结束执行。
 * 所以函数 0 总共执行 2 + 4 + 1 = 7 个单位时间，函数 1 总共执行 1 个单位时间。
 * <p>
 * 输入：n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]
 * 输出：[8,1]
 * <p>
 * 输入：n = 1, logs = ["0:start:0","0:end:0"]
 * 输出：[1]
 *
 * @author : yixihan
 * @create : 2022-08-07-8:35
 */
public class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Node> stack = new Stack<> ();
        int[] ans = new int[n];

        for (String log : logs) {
            String[] splits = log.split (":");
            int index = Integer.parseInt (splits[0]);
            String state = splits[1];
            int time = Integer.parseInt (splits[2]);

            if ("start".equals (state)) {
                stack.push (new Node (index, state, time));
            } else if ("end".equals (state)) {
                Node pop = stack.pop ();
                int interval = time - pop.time + 1;
                ans[pop.index] += interval;
                if (!stack.isEmpty ()) {
                    ans[stack.peek ().index] -= interval;
                }
            }
        }

        return ans;
    }

    class Node {
        int index;
        String state;
        int time;

        public Node() {
        }

        public Node(int index, String state, int time) {
            this.index = index;
            this.state = state;
            this.time = time;
        }
    }
}
