package com.yixihan.competition.week287;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : yixihan
 * @create : 2022-04-03-11:07
 */
public class FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();



        for (int[] match : matches) {
            winners.add (match[0]);
            if (losers.contains (match[1])) {
                losers.remove (match[1]);
                tmp.add (match[1]);
            } else if (! tmp.contains (match[1])){
                losers.add (match[1]);
            }
        }

        ArrayList<Integer> e = new ArrayList<> ();
        ArrayList<Integer> e1 = new ArrayList<> (losers);

        for (Integer winner : winners) {
            if (! losers.contains (winner) && ! tmp.contains (winner)) {
                e.add (winner);
            }
        }
        e1.sort (Integer::compare);
        e.sort (Integer::compare);
        ans.add (e);
        ans.add (e1);

        return ans;
    }
}
