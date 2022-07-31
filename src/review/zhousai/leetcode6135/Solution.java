package review.zhousai.leetcode6135;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    int[] p;

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        p = new int[n];
        int[] degree = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                degree[edges[i]]++;
                union(i, edges[i]);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            cnt++;
            if (edges[poll] != -1) {
                if (--degree[edges[poll]] == 0) {
                    deque.addLast(edges[poll]);
                }
            }
        }
        if (cnt == 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int e = find(i);
                int time = map.getOrDefault(e, 0);
                map.put(e, time + 1);

            }
            return map.values().stream().sorted((a, b) -> (b - a)).collect(Collectors.toList()).get(0);
        }
        return cnt == n ? -1 : n - cnt;
    }
}