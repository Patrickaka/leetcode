package tulun.leetcode417.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] height = {{3, 3, 3, 3, 3, 3}, {3, 0, 3, 3, 0, 3}, {3, 3, 3, 3, 3, 3}};
        Solution solution = new Solution();
        System.out.println(solution.pacificAtlantic(height));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Node[][] nodes = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node();
            }
        }
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        int[][] positions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    nodes[i][j].po = true;
                    d1.addLast(i * n + j);
                }
                if (i == m - 1 || j == n - 1) {
                    nodes[i][j].ao = true;
                    d2.addLast(i * n + j);
                }
            }
        }
        while (!d1.isEmpty()) {
            int poll = d1.pollFirst();
            int x = poll / n, y = poll % n;
            for (int[] position : positions) {
                int nx = x + position[0], ny = y + position[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (heights[x][y] > heights[nx][ny]) {
                    continue;
                }
                if (nodes[nx][ny].po) {
                    continue;
                }
                d1.add(nx * n + ny);
                nodes[nx][ny].po = true;
            }
        }
        while (!d2.isEmpty()) {
            int poll = d2.pollFirst();
            int x = poll / n, y = poll % n;
            for (int[] position : positions) {
                int nx = x + position[0], ny = y + position[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                if (heights[x][y] > heights[nx][ny]) {
                    continue;
                }
                if (nodes[nx][ny].ao) {
                    continue;
                }
                d2.add(nx * n + ny);
                nodes[nx][ny].ao = true;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nodes[i][j].ao && nodes[i][j].po) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    static class Node {
        boolean ao;
        boolean po;
    }
}