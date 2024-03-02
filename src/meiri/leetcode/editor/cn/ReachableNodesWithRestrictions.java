//现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。 
//
// 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给
//你一个整数数组 restricted 表示 受限 节点。 
//
// 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。 
//
// 注意，节点 0 不 会标记为受限节点。 
//
// 
//
// 示例 1： 
// 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
//输出：4
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。 
//
// 示例 2： 
// 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
//
//输出：3
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges 表示一棵有效的树 
// 1 <= restricted.length < n 
// 1 <= restricted[i] < n 
// restricted 中的所有值 互不相同 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 并查集 图 数组 哈希表 👍 45 👎 0

package meiri.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReachableNodesWithRestrictions {
    public static void main(String[] args) {
        Solution solution = new ReachableNodesWithRestrictions().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int n = (int) 1e5, m = n * 2;
        int idx = 0;
        int[] he = new int[n], ne = new int[m], e = new int[m];

        void add(int a, int b) {
            e[idx] = b;
            ne[idx] = he[a];
            he[a] = idx++;
        }

        Set<Integer> restrictedSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            Arrays.fill(he, -1);
            for (int num : restricted) {
                restrictedSet.add(num);
            }
            for (int[] e : edges) {
                add(e[0], e[1]);
                add(e[1], e[0]);
            }
            dfs(0, new HashSet<>());
            return set.size();
        }

        public void dfs(int root, Set<Integer> curSet) {
            if (restrictedSet.contains(root) || curSet.contains(root)) {
                return;
            }
            curSet.add(root);
            set.add(root);
            for (int i = he[root]; i != -1; i = ne[i]) {
                dfs(e[i], curSet);
            }
            curSet.remove(root);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}