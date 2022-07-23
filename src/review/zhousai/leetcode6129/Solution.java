package review.zhousai.leetcode6129;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 0, 0, 0, 0};
        System.out.println(solution.zeroFilledSubarray(nums));
    }

    public long zeroFilledSubarray(int[] nums) {
        long n = nums.length, cnt = 0;
        long ans = 0;
        int count = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count++;
                cnt++;
                if (i == n - 1) {
                    Long temp = map.getOrDefault(cnt, 0L);
                    map.put(cnt, temp + 1);
                    break;
                }
                if (nums[i + 1] != 0 && i != n - 1) {
                    Long temp = map.getOrDefault(cnt, 0L);
                    map.put(cnt, temp + 1);
                    cnt = 0;
                }
            }
        }

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            long key = entry.getKey(), value = entry.getValue();
            long time = 0L;
            for (long i = 1; i < key; i++) {
                time += i;
            }
            ans += time * value;
        }
        return ans + count;
    }
}