package com.yixihan.programming_ability_2.day19;

import java.util.HashMap;
import java.util.Map;

/**
 * 你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，
 * 这个验证码在 currentTimeentry时刻之后 timeToLiveentry秒过期。
 * 如果验证码被更新了，那么它会在 currentTimeentry（可能与之前的 currentTimeentry不同）
 * 时刻延长entrytimeToLiveentry秒。
 * <p>
 * 请你实现entryAuthenticationManagerentry类：
 * <p>
 * AuthenticationManager(int timeToLive)entry
 * 构造entryAuthenticationManagerentry并设置entrytimeToLiveentry参数。
 * generate(string tokenId, int currentTime)
 * entry给定 tokenIdentry，在当前时间entrycurrentTime 生成一个新的验证码。
 * renew(string tokenId, int currentTime)
 * entry将给定 tokenIdentry且 未过期entry的验证码在 currentTimeentry时刻更新。
 * 如果给定entrytokenIdentry对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
 * countUnexpiredTokens(int currentTime)
 * entry请返回在给定entrycurrentTimeentry时刻，未过期entry的验证码数目。
 * 如果一个验证码在时刻entrytentry过期，且另一个操作恰好在时刻entrytentry发生
 * （renewentry或者entrycountUnexpiredTokensentry操作），过期事件entry优先于entry其他操作。
 * <p>
 * entry
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：
 * ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
 * [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
 * 输出：
 * [null, null, null, 1, null, null, null, 0]
 * <p>
 * 解释：
 * AuthenticationManager authenticationManager = new AuthenticationManager(5);
 * // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
 * authenticationManager.renew("aaa", 1);
 * // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
 * authenticationManager.generate("aaa", 2);
 * // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
 * authenticationManager.countUnexpiredTokens(6);
 * // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
 * authenticationManager.generate("bbb", 7);
 * // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
 * authenticationManager.renew("aaa", 8);
 * // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
 * authenticationManager.renew("bbb", 10);
 * // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
 * authenticationManager.countUnexpiredTokens(15);
 * // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，
 * 所有验证码均已过期，所以返回 0 。
 *
 * @author : yixihan
 * @create : 2022-04-10-14:48
 */
public class AuthenticationManager {

    int timeToLive;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<> ();
    }

    public void generate(String tokenId, int currentTime) {
        map.put (tokenId, currentTime);
        // System.out.println (map);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = map.get (tokenId);
        if (time != null && time + timeToLive > currentTime) {
            map.put (tokenId, currentTime);
        }

        // System.out.println (map);
    }

    public int countUnexpiredTokens(int currentTime) {

        //        long count = map.entrySet ()
        //                .stream ()
        //                .filter (entry -> entry.getValue () + timeToLive > currentTime)
        //                .count ();
        //
        //        return (int) count;
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            if (entry.getValue () + timeToLive > currentTime) {
                count++;
            }
        }
        return count;
    }

}
