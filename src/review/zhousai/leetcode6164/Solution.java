package review.zhousai.leetcode6164;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {368, 369, 307, 304, 384, 138, 90, 279, 35, 396, 114, 328, 251, 364, 300, 191, 438, 467, 183};
        System.out.println(solution.maximumSum(nums));
    }

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int sum = getSum(num);
            List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
            list.add(num);
            map.put(sum, list);
        }
        for (List<Integer> l : map.values()) {
            if (l.size() > 1) {
                int s = 0;
                l.sort((a, b) -> (b - a));
                s = l.get(0) + l.get(1);
                if (s > ans) {
                    ans = s;
                }
            }
        }
        return ans;
    }

    int getSum(int x) {
        int ans = 0;
        while (x != 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }
}