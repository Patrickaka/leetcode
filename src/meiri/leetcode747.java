package meiri;

class Solution747 {
    public int dominantIndex(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max1 = -1, max2 = -1, maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max2 * 2 <= max1 ? maxIndex : -1;
    }
}