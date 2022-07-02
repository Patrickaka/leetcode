package tanxin.leetcode871.tanxin;

import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length, ans = 0, idx = 0, loc = 0, remain = startFuel;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        while (loc < target) {
            if (remain == 0) {
                if (!queue.isEmpty()) {
                    ans++;
                    remain += queue.poll();
                } else {
                    return -1;
                }
            }
            loc += remain;
            remain = 0;
            while (idx < n && stations[idx][0] <= loc) {
                queue.add(stations[idx][1]);
                idx++;
            }
        }
        return ans;
    }
}