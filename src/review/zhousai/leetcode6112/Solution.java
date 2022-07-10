package review.zhousai.leetcode6112;

import java.util.PriorityQueue;

class Solution {
    public int fillCups(int[] amount) {
        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int i : amount) {
            if (i > 0) {
                q.add(i);
            }
        }
        while (q.size() >= 2) {
            System.out.println(q);
            int a1 = q.poll();
            int a2 = q.poll();
            if (a1 > 0 && a2 > 0) {
                a1--;
                a2--;
            }
            if (a1 > 0) {
                q.add(a1);
            }
            if (a2 > 0) {
                q.add(a2);
            }
            ans++;
        }
        return ans + (q.size() == 0 ? 0 : q.poll());
    }
}