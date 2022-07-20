package tulun.leetcode851;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        inDegree[b]++;
    }

    int n = 500, m = n * (n - 1) / 2, idx = 0;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        int[] ans = new int[len];
        Arrays.fill(he, -1);
        int num = 0;
        for (int[] rich : richer) {
            add(rich[0], rich[1]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < quiet.length; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
            ans[i] = i;
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (quiet[ans[poll]] < quiet[ans[j]]) {
                    ans[j] = ans[poll];
                }
                if (--inDegree[j] == 0) {
                    deque.add(j);
                }
            }
        }
        return ans;
    }

    int[] he = new int[n], ne = new int[m], e = new int[m], inDegree = new int[n];


}