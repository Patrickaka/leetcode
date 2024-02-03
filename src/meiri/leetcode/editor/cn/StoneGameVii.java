//石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。 
//
// 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得
//分较高者获胜。 
//
// 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。 
//
// 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分
//的差值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [5,3,1,4,2]
//输出：6
//解释：
//- 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
//- 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
//- 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
//- 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
//- 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
//得分的差值 18 - 12 = 6 。
// 
//
// 示例 2： 
//
// 
//输入：stones = [7,90,5,1,100,10,10,2]
//输出：122 
//
// 
//
// 提示： 
//
// 
// n == stones.length 
// 2 <= n <= 1000 
// 1 <= stones[i] <= 1000 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 90 👎 0

package meiri.leetcode.editor.cn;

public class StoneGameVii {
    public static void main(String[] args) {
        Solution solution = new StoneGameVii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            int[] sums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sums[i] = sums[i - 1] + stones[i - 1];
            }
            int[] dp = new int[n + 1];
            for (int i = n - 1; i > 0; i--) {
                for (int j = i + 1; j <= n; j++) {
                    dp[j] = Math.max(sums[j] - sums[i] - dp[j], sums[j - 1] - sums[i - 1] - dp[j - 1]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}