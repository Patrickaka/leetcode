package tulun.leetcode802;

import java.util.*;

class Solution {

    int M = (int) 1e4, N = (int) 1e4 * 4, idx = 0;

    int[] he = new int[M], ne = new int[N], e = new int[N], inDegree = new int[N];

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        Solution solution = new Solution();
        System.out.println(solution.eventualSafeNodes(graph));
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        inDegree[b]++;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                add(graph[i][j], i);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int b = e[i];
                if (--inDegree[b] == 0) {
                    deque.addLast(b);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}