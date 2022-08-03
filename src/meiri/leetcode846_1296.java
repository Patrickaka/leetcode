package meiri;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution846_1926 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int j : hand) {
            map.put(j, map.getOrDefault(j, 0) + 1);
            queue.add(j);
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (map.get(temp) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int cnt = map.getOrDefault(temp + i, 0);
                if (cnt == 0) {
                    return false;
                }
                map.put(temp + i, cnt - 1);
            }
        }
        return true;
    }
}