package tulun.leetcode433;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Map<String, Integer> map = new HashMap<>();
        Deque<String> deque = new ArrayDeque<>();
        deque.add(start);
        map.put(start, 0);
        while (!deque.isEmpty()) {
            String poll = deque.pollFirst();
            System.out.println(poll);
            int step = map.get(poll);
            if (poll.equals(end)) {
                return step;
            }
            for (String s : bank) {
                if (map.containsKey(s)) {
                    continue;
                }
                int cnt = 0;
                for (int i = 0; i < 8; i++) {
                    if (s.charAt(i) != poll.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt == 1) {
                    map.put(s, step + 1);
                    deque.add(s);
                }
            }
        }
        return -1;
    }
}