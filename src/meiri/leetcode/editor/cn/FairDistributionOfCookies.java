//给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，所有 
//零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。 
//
// 分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。 
//
// 返回所有分发的最小不公平程度。 
//
// 
//
// 示例 1： 
//
// 输入：cookies = [8,15,10,20,8], k = 2
//输出：31
//解释：一种最优方案是 [8,15,8] 和 [10,20] 。
//- 第 1 个孩子分到 [8,15,8] ，总计 8 + 15 + 8 = 31 块饼干。
//- 第 2 个孩子分到 [10,20] ，总计 10 + 20 = 30 块饼干。
//分发的不公平程度为 max(31,30) = 31 。
//可以证明不存在不公平程度小于 31 的分发方案。
// 
//
// 示例 2： 
//
// 输入：cookies = [6,1,3,2,2,4,1,2], k = 3
//输出：7
//解释：一种最优方案是 [6,1]、[3,2,2] 和 [4,1,2] 。
//- 第 1 个孩子分到 [6,1] ，总计 6 + 1 = 7 块饼干。 
//- 第 2 个孩子分到 [3,2,2] ，总计 3 + 2 + 2 = 7 块饼干。
//- 第 3 个孩子分到 [4,1,2] ，总计 4 + 1 + 2 = 7 块饼干。
//分发的不公平程度为 max(7,7,7) = 7 。
//可以证明不存在不公平程度小于 7 的分发方案。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cookies.length <= 8 
// 1 <= cookies[i] <= 10⁵ 
// 2 <= k <= cookies.length 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 90 👎 0

package meiri.leetcode.editor.cn;

import java.util.Arrays;

public class FairDistributionOfCookies {
    public static void main(String[] args) {
        Solution solution = new FairDistributionOfCookies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCookies(int[] cookies, int k) {
            int n = cookies.length, INF = 0x3f3f3f3f, mask = 1 << n;
            int[] g = new int[mask];
            for (int s = 0; s < mask; s++) {
                int t = 0;
                for (int i = 0; i < n; i++) {
                    t += ((s >> i) & 1) == 1 ? cookies[i] : 0;
                }
                g[s] = t;
            }
            //dp[i][j] ==> i个孩子，分j的礼盒，最小的公平指数
            int[][] dp = new int[k + 10][mask];
            for (int[] arr : dp) {
                Arrays.fill(arr, INF);
            }
            dp[0][0] = 0;
            for (int i = 1; i <= k; i++) {
                for (int s = 0; s < mask; s++) {
                    for (int p = s; p != 0; p = (p - 1) & s) {
                        dp[i][s] = Math.min(dp[i][s], Math.max(dp[i - 1][s - p], g[p]));
                    }
                }
            }
            return dp[k][mask - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}