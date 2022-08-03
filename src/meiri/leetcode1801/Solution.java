package meiri.leetcode1801;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    final static int MOD = (int) 1e9 + 7;

    public int getNumberOfBacklogOrders(int[][] orders) {
        int ans = 0;
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> from, to;
        boolean fromIsSell;
        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            int[] cur;
            if (orderType == 0) {
                from = sell;
                to = buy;
                fromIsSell = true;
            } else {
                from = buy;
                to = sell;
                fromIsSell = false;
            }
            while (amount > 0 && !from.isEmpty() && (fromIsSell ? from.peek()[0] <= price : from.peek()[0] >= price)) {
                cur = from.poll();
                int cnt = Math.min(cur[1], amount);
                cur[1] -= cnt;
                amount -= cnt;
                if (cur[1] > 0) {
                    from.add(cur);
                }
            }
            if (amount > 0) {
                to.add(new int[]{price, amount, orderType});
            }
        }
        for (PriorityQueue<int[]> q : new PriorityQueue[]{buy, sell}) {
            while (!q.isEmpty()) {
                ans += q.poll()[1];
                ans %= MOD;
            }
        }
        return ans;
    }
}