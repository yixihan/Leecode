package com.yixihan.month12.day1005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。
 * 顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。
 * 当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
 * <p>
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
 * <p>
 * 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。
 * 可以按 任意顺序 返回答案。
 * <p>
 * 输入：cpdomains = ["9001 discuss.leetcode.com"]
 * 输出：["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
 * 解释：例子中仅包含一个网站域名："discuss.leetcode.com"。
 * 按照前文描述，子域名 "leetcode.com" 和 "com" 都会被访问，所以它们都被访问了 9001 次。
 * <p>
 * 输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * 解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1 次，"wiki.org" 5 次。
 * 而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5 次。
 *
 * @author yixihan
 * @date 2022-10-05-8:41
 */
public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<> ();

        for (String cpdomain : cpdomains) {
            int index = cpdomain.indexOf (" ");
            int cnt = Integer.parseInt (cpdomain.substring (0, index));
            String[] splits = cpdomain.substring (index + 1).split ("\\.");
            StringBuilder sb = new StringBuilder ();
            for (int i = splits.length - 1; i >= 0; i--) {
                sb.insert (0, splits[i]);
                map.put (sb.toString (), map.getOrDefault (sb.toString (), 0) + cnt);
                sb.insert (0, ".");
            }

        }

        List<String> list = new ArrayList<> (map.size ());
        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            list.add (entry.getValue () + " " + entry.getKey ());
        }

        return list;
    }
}
