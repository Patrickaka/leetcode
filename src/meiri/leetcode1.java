package meiri;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int length = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            int t = target - nums[i];
            if(numMap.containsKey(t)){
                return new int[]{numMap.get(t), i};
            }
            numMap.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}