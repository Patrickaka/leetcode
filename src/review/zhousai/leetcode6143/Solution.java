package review.zhousai.leetcode6143;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3));
    }

    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        int n = tasks.length;
        long now = 1;
        for (int i = 0; i < n; ) {
            long l = map.getOrDefault(tasks[i], -1L);
            if (l == -1 || l + space < now) {
                map.put(tasks[i], now);
                i++;
                now++;
            } else if (l + space >= now) {
                now = l + space + 1;
                map.put(tasks[i], now);
                i++;
                now++;
            }
        }
        return now - 1;
    }
}