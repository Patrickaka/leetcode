//给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。 
//
// 一个整数数组的 能量 定义为和 等于 k 的子序列的数目。 
//
// 请你返回 nums 中所有子序列的 能量和 。 
//
// 由于答案可能很大，请你将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3], k = 3 
// 
//
// 输出： 6 
//
// 解释： 
//
// 总共有 5 个能量不为 0 的子序列： 
//
// 
// 子序列 [1,2,3] 有 2 个和为 3 的子序列：[1,2,3] 和 [1,2,3] 。 
// 子序列 [1,2,3] 有 1 个和为 3 的子序列：[1,2,3] 。 
// 子序列 [1,2,3] 有 1 个和为 3 的子序列：[1,2,3] 。 
// 子序列 [1,2,3] 有 1 个和为 3 的子序列：[1,2,3] 。 
// 子序列 [1,2,3] 有 1 个和为 3 的子序列：[1,2,3] 。 
// 
//
// 所以答案为 2 + 1 + 1 + 1 + 1 = 6 。 
//
// 示例 2： 
//
// 
// 输入： nums = [2,3,3], k = 5 
// 
//
// 输出： 4 
//
// 解释： 
//
// 总共有 3 个能量不为 0 的子序列： 
//
// 
// 子序列 [2,3,3] 有 2 个子序列和为 5 ：[2,3,3] 和 [2,3,3] 。 
// 子序列 [2,3,3] 有 1 个子序列和为 5 ：[2,3,3] 。 
// 子序列 [2,3,3] 有 1 个子序列和为 5 ：[2,3,3] 。 
// 
//
// 所以答案为 2 + 1 + 1 = 4 。 
//
// 示例 3： 
//
// 
// 输入： nums = [1,2,3], k = 7 
// 
//
// 输出： 0 
//
// 解释：不存在和为 7 的子序列，所以 nums 的能量和为 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 1 <= nums[i] <= 10⁴ 
// 1 <= k <= 100 
// 
//
// 👍 3 👎 0

package meiri.leetcode.editor.cn;

public class FindTheSumOfThePowerOfAllSubsequences {
    public static void main(String[] args) {
        Solution solution = new FindTheSumOfThePowerOfAllSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumOfPower(int[] nums, int k) {
            int MOD = (int) 1e9 + 7;
            int n = nums.length;
            //dp[i]表示nums的子序列中能量和为i的数量
            int[] dp = new int[k + 1];
            if (nums[0] <= k) {
                dp[nums[0]] = 1;
            }
            //cur为当前子序列的数量
            int cur = 1;
            for (int i = 1; i < n; i++) {
                int[] f = new int[k + 1];
                for (int j = 1; j <= k; j++) {
                    //nums[i]不参与能量值序列
                    f[j] = dp[j] * 2 % MOD;
                    //nums[i]参与能量值序列
                    if (nums[i] == j) {
                        f[j] = (f[j] + cur + 1) % MOD;
                    } else if (nums[i] < j) {
                        f[j] = (f[j] + dp[j - nums[i]]) % MOD;
                    }
                }
                dp = f;
                cur = (cur * 2 + 1) % MOD;
            }
            return dp[k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}