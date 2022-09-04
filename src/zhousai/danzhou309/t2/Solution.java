package zhousai.danzhou309.t2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfWays(989,
                1000,
                99));
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        if (startPos + k == endPos) {
            return 1;
        }
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        deque.add(startPos);
        while (k-- > 0) {
            int size = deque.size();

            while (size-- > 0) {
                int poll = deque.pollFirst();
                if (!map.containsKey(poll - 1)) {
                    deque.addLast(poll - 1);
                }
                if (!map.containsKey(poll + 1)) {
                    deque.addLast(poll + 1);
                }
                map.merge(poll - 1, 1, Integer::sum);
                map.merge(poll + 1, 1, Integer::sum);
                if (k == 0) {
                    if (poll - 1 == endPos) {
                        ans += map.get(poll - 1);
                    }
                    if (poll + 1 == endPos) {
                        ans += map.get(poll + 1);
                    }
                }
            }
        }
        return ans;
    }
}