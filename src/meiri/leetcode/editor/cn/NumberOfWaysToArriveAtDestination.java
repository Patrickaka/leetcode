//你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两
//个路口之间最多有一条路。 
//
// 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费
// timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。 
//
// 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
// 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2
//,5,1],[0,4,5],[4,6,2]]
//输出：4
//解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
//四条花费 7 分钟的路径分别为：
//- 0 ➝ 6
//- 0 ➝ 4 ➝ 6
//- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
//- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
// 
//
// 示例 2： 
//
// 输入：n = 2, roads = [[1,0,10]]
//输出：1
//解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n - 1 <= roads.length <= n * (n - 1) / 2 
// roads[i].length == 3 
// 0 <= ui, vi <= n - 1 
// 1 <= timei <= 10⁹ 
// ui != vi 
// 任意两个路口之间至多有一条路。 
// 从任意路口出发，你能够到达其他任意路口。 
// 
//
// Related Topics 图 拓扑排序 动态规划 最短路 👍 95 👎 0

package meiri.leetcode.editor.cn;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToArriveAtDestination().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int N = 210, mod = (int) 1e9 + 7;
        int[][] g;
        int[] in = new int[N];
        long[] dist = new long[N];
        boolean[] visited = new boolean[N];
        long maxTime = Long.MAX_VALUE, res = 0;
        int n;

        public int countPaths(int _n, int[][] roads) {
            n = _n;
            g = new int[n][n];
            for (int[] road : roads) {
                g[road[0]][road[1]] = road[2];
                g[road[1]][road[0]] = road[2];
            }
            // 求出dist[] 最短路数组
            dijkstra();
            for (int[] road : roads) {
                int a = road[0], b = road[1], c = road[2];
                g[a][b] = g[b][a] = 0;
                if (dist[a] + c == dist[b]) {
                    g[a][b] = c;
                    in[b]++;
                } else if (dist[b] + c == dist[a]) {
                    g[b][a] = c;
                    in[a]++;
                }
            }
            //拓扑排序
            Deque<Integer> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (in[i] == 0) {
                    d.addLast(i);
                }
            }
            int[] f = new int[n];
            f[0] = 1;
            while (!d.isEmpty()) {
                int x = d.pollFirst();
                for (int i = 0; i < n; i++) {
                    if (g[x][i] == 0) {
                        continue;
                    }
                    f[i] += f[x];
                    f[i] %= mod;
                    if (--in[i] == 0) {
                        d.addLast(i);
                    }
                }
            }
            return f[n - 1];
        }

        void dijkstra() {
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[0] = 0;
            for (int i = 0; i < n; i++) {
                int t = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && (t == -1 || dist[j] < dist[t])) {
                        t = j;
                    }
                }
                visited[t] = true;
                for (int j = 0; j < n; j++) {
                    if (g[t][j] == 0) {
                        continue;
                    }
                    dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}