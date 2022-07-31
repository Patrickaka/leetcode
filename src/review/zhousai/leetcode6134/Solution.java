package review.zhousai.leetcode6134;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    static int N = (int) 1e5;
    int n;
    int[] edges;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] edges = {4, 3, 0, 5, 3, -1};
        System.out.println(s.closestMeetingNode(edges, 4, 0));
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        this.edges = edges;
        n = edges.length;
        if (node1 == node2) {
            return node1;
        }
        int ans = N + 1, minStep = N + 1;
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        d1.add(node1);
        m1.put(node1, 0);
        d2.add(node2);
        m2.put(node2, 0);
        while (!d1.isEmpty()) {
            int poll = d1.poll();
            int step = m1.get(poll);
            if (edges[poll] != -1 && !m1.containsKey(edges[poll])) {
                d1.addLast(edges[poll]);
                m1.put(edges[poll], step + 1);
            }
        }
        while (!d2.isEmpty()) {
            int poll = d2.poll();
            int step = m2.get(poll);
            if (edges[poll] != -1 && !m2.containsKey(edges[poll])) {
                d2.addLast(edges[poll]);
                m2.put(edges[poll], step + 1);
            }
        }
        for (int key : m1.keySet()) {
            if (m2.containsKey(key)) {
                int temp = Math.max(m1.get(key), m2.get(key));
                if (temp < minStep) {
                    minStep = temp;
                    ans = key;
                }
            }
        }
        return ans == N + 1 ? -1 : ans;
    }
}