package zhousai.shuangzhou83.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Integer, Integer> map = new HashMap<>();
        char c = suits[0];
        boolean ok = true;
        for (int i = 0; i < 5; i++) {
            int cnt = map.getOrDefault(ranks[i], 0);
            map.put(ranks[i], ++cnt);
            if (suits[i] != c) {
                ok = false;
            }
        }
        if (ok) {
            return "Flush";
        }
        Integer integer = map.values().stream().sorted((a, b) -> (b - a)).collect(Collectors.toList()).get(0);
        if (integer == 3) {
            return "Three of a Kind";
        }
        if (integer == 2) {
            return "Pair";
        }
        return "High Card";
    }
}