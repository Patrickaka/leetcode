import java.util.Arrays;

class Solution689 {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[3];
        int maxSum1 = 0, maxSum2 = 0, maxSum3 = 0;
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int sum1Index = 0, sum2Index = 0, sum1Index1 = 0;
        for (int i = 2 * k; i < length; i++) {
            sum1 += nums[i - 2 * k];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= 3 * k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    sum1Index = i - 3 * k + 1;
                }
                if (maxSum1 + sum2 > maxSum2) {
                    maxSum2 = maxSum1 + sum2;
                    sum1Index1 = sum1Index;
                    sum2Index = i - 2 * k + 1;
                }
                if (maxSum2 + sum3 > maxSum3) {
                    maxSum3 = maxSum2 + sum3;
                    result[0] = sum1Index1;
                    result[1] = sum2Index;
                    result[2] = i - k + 1;
                }
                sum1 -= nums[i - 3 * k + 1];
                sum2 -= nums[i - 2 * k + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 10, 6, 11, 17, 4, 11, 1, 3};
        int k = 1;
        int[] result = maxSumOfThreeSubarrays(nums, k);
        System.out.println(Arrays.toString(result));
    }
}