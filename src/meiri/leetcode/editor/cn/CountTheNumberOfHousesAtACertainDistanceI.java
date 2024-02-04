//给你三个 正整数 n 、x 和 y 。 
//
// 在城市中，存在编号从 1 到 n 的房屋，由 n 条街道相连。对所有 1 <= i < n ，都存在一条街道连接编号为 i 的房屋与编号为 i + 1 的
//房屋。另存在一条街道连接编号为 x 的房屋与编号为 y 的房屋。 
//
// 对于每个 k（1 <= k <= n），你需要找出所有满足要求的 房屋对 [house1, house2] ，即从 house1 到 house2 需要经
//过的 最少 街道数为 k 。 
//
// 返回一个下标从 1 开始且长度为 n 的数组 result ，其中 result[k] 表示所有满足要求的房屋对的数量，即从一个房屋到另一个房屋需要经过的
// 最少 街道数为 k 。 
//
// 注意，x 与 y 可以 相等 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3, x = 1, y = 3
//输出：[6,0,0]
//解释：让我们检视每个房屋对
//- 对于房屋对 (1, 2)，可以直接从房屋 1 到房屋 2。
//- 对于房屋对 (2, 1)，可以直接从房屋 2 到房屋 1。
//- 对于房屋对 (1, 3)，可以直接从房屋 1 到房屋 3。
//- 对于房屋对 (3, 1)，可以直接从房屋 3 到房屋 1。
//- 对于房屋对 (2, 3)，可以直接从房屋 2 到房屋 3。
//- 对于房屋对 (3, 2)，可以直接从房屋 3 到房屋 2。
// 
//
// 示例 2： 
// 
// 
//输入：n = 5, x = 2, y = 4
//输出：[10,8,2,0,0]
//解释：对于每个距离 k ，满足要求的房屋对如下：
//- 对于 k == 1，满足要求的房屋对有 (1, 2), (2, 1), (2, 3), (3, 2), (2, 4), (4, 2), (3, 4), 
//(4, 3), (4, 5), 以及 (5, 4)。
//- 对于 k == 2，满足要求的房屋对有 (1, 3), (3, 1), (1, 4), (4, 1), (2, 5), (5, 2), (3, 5), 
//以及 (5, 3)。
//- 对于 k == 3，满足要求的房屋对有 (1, 5)，以及 (5, 1) 。
//- 对于 k == 4 和 k == 5，不存在满足要求的房屋对。
// 
//
// 示例 3： 
// 
// 
//输入：n = 4, x = 1, y = 1
//输出：[6,4,2,0]
//解释：对于每个距离 k ，满足要求的房屋对如下：
//- 对于 k == 1，满足要求的房屋对有 (1, 2), (2, 1), (2, 3), (3, 2), (3, 4), 以及 (4, 3)。
//- 对于 k == 2，满足要求的房屋对有 (1, 3), (3, 1), (2, 4), 以及 (4, 2)。
//- 对于 k == 3，满足要求的房屋对有 (1, 4), 以及 (4, 1)。
//- 对于 k == 4，不存在满足要求的房屋对。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= x, y <= n 
// 
//
// Related Topics 广度优先搜索 图 前缀和 👍 5 👎 0

package meiri.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfHousesAtACertainDistanceI {
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfHousesAtACertainDistanceI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countOfPairs(int n, int x, int y) {
            int[] res = new int[n];
            int[][] g = new int[n + 1][n + 1];
            for (int i = 1; i < n; i++) {
                g[i][i + 1] = 1;
                g[i + 1][i] = 1;
            }
            if (x != y) {
                g[x][y] = 1;
                g[y][x] = 1;
            }
            for (int i = 1; i <= n; i++) {
                Deque<Integer> deque = new ArrayDeque<>();
                Set<Integer> set = new HashSet<>();
                int step = 0;
                deque.add(i);
                set.add(i);
                while (!deque.isEmpty()) {
                    int cnt = deque.size();
                    while (cnt-- > 0) {
                        int cur = deque.poll();
                        for (int k = 1; k <= n; k++) {
                            if (g[cur][k] == 1 && !set.contains(k)) {
                                set.add(k);
                                deque.add(k);
                                res[step]++;
                            }
                        }
                    }
                    step++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}