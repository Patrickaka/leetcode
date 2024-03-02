//给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] =
// [ui, vi] 表示节点 ui 和 vi 在树中有一条边。 
//
// 请你返回树中的 合法路径数目 。 
//
// 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。 
//
// 注意： 
//
// 
// 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。 
// 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
//输出：4
//解释：恰好有一个质数编号的节点路径有：
//- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
//- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
//- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
//- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
//只有 4 条合法路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
//输出：6
//解释：恰好有一个质数编号的节点路径有：
//- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
//- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
//- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
//- (1, 6) 因为路径 1 到 6 只包含一个质数 3 。
//- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
//- (3, 6) 因为路径 3 到 6 只包含一个质数 3 。
//只有 6 条合法路径。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 输入保证 edges 形成一棵合法的树。 
// 
//
// Related Topics 树 深度优先搜索 数学 动态规划 数论 👍 30 👎 0

package meiri.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class CountValidPathsInATree {
    public static void main(String[] args) {
        Solution solution = new CountValidPathsInATree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        int[][] g;
        int _n;

        Set<Integer> zhiSet = new HashSet<>();

        Set<Long> resSet = new HashSet<>();

        public long countPaths(int n, int[][] edges) {
            long res = 0;
            _n = n;
            for (int i = 1; i <= n; i++) {
                if (check(i)) {
                    zhiSet.add(i);
                }
            }
            g = new int[n + 1][n + 1];
            for (int[] e : edges) {
                g[e[0]][e[1]] = 1;
                g[e[1]][e[0]] = 1;
            }
            for (int i = 1; i <= n; i++) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                res += dfs(i, i, zhiSet.contains(i), 0, set);
            }
            return res;
        }

        long dfs(int start, int root, boolean flag, int cnt, Set<Integer> set) {
            long res = 0;
            for (int i = 1; i <= _n; i++) {
                if (g[root][i] == 1 && i != start && !set.contains(i)) {
                    set.add(i);
                    boolean zhi = zhiSet.contains(i);
                    long curIndex;
                    if (start < i) {
                        curIndex = (long) start * _n + i;
                    } else {
                        curIndex = (long) i * _n + start;
                    }
                    if (zhi && !flag) {
                        if (resSet.contains(curIndex)) {
                            res += dfs(start, i, true, 0, set);
                        } else {
                            resSet.add(curIndex);
                            res += dfs(start, i, true, 1, set);
                        }
                    } else if (!zhi && flag) {
                        if (resSet.contains(curIndex)) {
                            res += dfs(start, i, flag, 0, set);
                        } else {
                            resSet.add(curIndex);
                            res += dfs(start, i, true, 1, set);
                        }
                    } else if (!zhi) {
                        res += dfs(start, i, false, 0, set);
                    }
                    set.remove(i);
                }
            }
            return res + cnt;
        }

        boolean check(int n) {
            if (n <= 3) {
                return n > 1;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}