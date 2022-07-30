package offerII.offerII03;

class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] < i) {
                return nums[i];
            }
            int temp = nums[nums[i]];
            if (nums[i] == temp) {
                return temp;
            }
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }
}