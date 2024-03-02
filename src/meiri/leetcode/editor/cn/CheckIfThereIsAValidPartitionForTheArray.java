//给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。 
//
// 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分： 
//
// 
// 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。 
// 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。 
// 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。 
// 
//
// 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,4,5,6]
//输出：true
//解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
//这是一种有效划分，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2]
//输出：false
//解释：该数组不存在有效划分。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 数组 动态规划 👍 77 👎 0

package meiri.leetcode.editor.cn;

public class CheckIfThereIsAValidPartitionForTheArray {
    public static void main(String[] args) {
        Solution solution = new CheckIfThereIsAValidPartitionForTheArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPartition(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            if (nums[1] == nums[0]) {
                dp[1] = true;
            }
            for (int i = 2; i < n; i++) {
                boolean cur1 = false, cur2 = false, cur3 = false;
                if (nums[i] == nums[i - 1]) {
                    cur1 = dp[i - 2];
                }
                if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                    if (i == 2) {
                        cur2 = true;
                    } else {
                        cur2 = dp[i - 3];
                    }
                }
                if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2) {
                    if (i == 2) {
                        cur3 = true;
                    } else {
                        cur3 = dp[i - 3];
                    }
                }
                dp[i] = cur1 | cur2 | cur3;
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}