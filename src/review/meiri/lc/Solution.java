package review.meiri.lc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    static int M = 510;
    int idx = 0;
    int[] he = new int[M], ne = new int[M], e = new int[M], degree = new int[M];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        degree[b]++;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Arrays.fill(he, -1);
        int n = quiet.length, max = 10000;
        int[] ans = new int[n];
        for (int[] arr : richer) {
            add(arr[0], arr[1]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (degree[i] == 0) {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                if (quiet[ans[poll]] < quiet[ans[e[i]]]) {
                    ans[e[i]] = ans[poll];
                }
                if (--degree[e[i]] == 0) {
                    deque.addLast(e[i]);
                }
            }
        }
        return ans;
    }
}