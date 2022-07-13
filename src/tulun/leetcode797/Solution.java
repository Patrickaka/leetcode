package tulun.leetcode797;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int[][] graph;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(solution.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        cur.add(0);
        dfs(0);
        return ans;
    }

    void dfs(int root) {
        if (root == n - 1) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int e : graph[root]) {
            cur.add(e);
            dfs(e);
            cur.remove(cur.size() - 1);
        }
    }
}