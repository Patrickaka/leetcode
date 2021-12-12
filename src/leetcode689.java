import java.util.Arrays;

class Solution689 {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[3];
        int maxNums1 = 0;
        int nums1 = 0;
        for (int i = 0; i < length; i++) {
            nums1 += nums[i];
            if(i > k - 1){
                if(nums1 > maxNums1){
                    maxNums1 = nums1;
                    result[0] = i;
                }
                nums1 -= nums[i - k + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] result = maxSumOfThreeSubarrays(nums, k);
        System.out.println(Arrays.toString(result));
    }
}