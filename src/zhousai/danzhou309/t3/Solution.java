package zhousai.danzhou309.t3;

class Solution {
    public static void main(String[] args) {
        int[] nums = {84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1, 1048576, 16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525, 739558112, 267703680};
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubarray(nums));
    }

    public int longestNiceSubarray(int[] nums) {
        int n = nums.length, max = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            int sum = 1;
            for (int j = i - 1; j >= i - dp[i - 1]; j--) {
                if ((nums[j] & nums[i]) == 0) {
                    sum++;
                }
            }
            dp[i] = sum;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}