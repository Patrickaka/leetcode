package offer.offer59I;

import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int n = nums.length, m = n - k + 1;
        int[] res = new int[m];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < k; i++) {
            q.add(new int[]{i, nums[i]});
        }
        int l = 0, r = k;
        while (r <= n) {
            int[] max = q.peek();
            while (max[0] < l) {
                q.remove(max);
                max = q.peek();
            }
            res[r - k] = max[1];
            l++;
            if (r != n) {
                q.add(new int[]{r, nums[r++]});
            }
        }
        return res;
    }
}