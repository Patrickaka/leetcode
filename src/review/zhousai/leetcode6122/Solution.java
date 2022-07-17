package review.zhousai.leetcode6122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    int[] numsDivide;

    public static void main(String[] args) {
        int[] nums = {37, 37};
        int[] numsDivide = {399309920, 289361645};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(nums, numsDivide));
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        this.numsDivide = numsDivide;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int s = map.getOrDefault(num, 0);
            map.put(num, s + 1);
        }
        Arrays.sort(numsDivide);
        int max = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            max = fac(max, numsDivide[i]);
        }

        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int num : collect) {
            if (num > max) {
                return -1;
            }
            if (max % num == 0) {
                return ans;
            }
            ans += map.get(num);
        }
        return ans;
    }

    int fac(int x1, int x2) {
        int d = 1;
        int a = Math.max(x1, x2), b = Math.min(x1, x2);
        while (b != 0) {
            d = a % b;
            a = b;
            b = d;
        }
        return a;
    }
}