package meiri;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution373 {
    boolean flag = true;

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        if (n > m) {
            flag = false;
            return kSmallestPairs(nums2, nums1, k);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for (int i = 0; i < Math.min(n, k); i++) {
            q.add(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty() && ans.size() < k) {
            List<Integer> temp = new ArrayList<>();
            int[] t = q.poll();
            if (t[1] + 1 < m) {
                q.add(new int[]{t[0], t[1] + 1});
            }
            temp.add(flag ? nums1[t[0]] : nums2[t[1]]);
            temp.add(flag ? nums2[t[1]] : nums1[t[0]]);
            ans.add(temp);
        }
        return ans;
    }
}