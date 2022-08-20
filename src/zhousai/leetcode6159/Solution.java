package zhousai.leetcode6159;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 11, 1};
        int[] removeQueries = {3, 2, 1, 0};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maximumSegmentSum(nums, removeQueries)));
    }

    /**
     * 数据结构题--利用TreeSet和TreeMap
     * 将每次被删除的数字放入到set
     * 将分割后的区间放入map
     *
     * @param nums          整数数组
     * @param removeQueries 第i次查询删除掉nums的第i个数字
     * @return 第i次删除操作以后的最大子段和
     */
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        TreeSet<Integer> bound = new TreeSet<>();
        long[] prefix = new long[(int) 1e5 + 1];

        int n = nums.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        bound.add(0);
        bound.add(n + 1);
        for (int i = 0; i < n; i++) {
            int pos = removeQueries[i] + 1;
            var left = bound.lower(pos);
            var right = bound.higher(pos);
            if (left == null || right == null) {
                continue;
            }
            long idx = prefix[right - 1] - prefix[left];
            var cnt = map.get(idx);
            if (cnt != null) {
                if (cnt == 1) {
                    map.remove(idx);
                } else {
                    map.put(idx, cnt - 1);
                }
            }
            long lSum = prefix[pos - 1] - prefix[left];
            long rSum = prefix[right - 1] - prefix[pos];
            bound.add(pos);
            map.put(lSum, map.getOrDefault(lSum, 0) + 1);
            map.put(rSum, map.getOrDefault(rSum, 0) + 1);
            ans[i] = map.lastKey();
        }
        return ans;
    }
}