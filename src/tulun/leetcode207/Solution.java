package tulun.leetcode207;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    int m = (int) 1e5, n = 5000, idx = 0;
    int[] he = new int[m], ne = new int[n], e = new int[n], inDegree = new int[m];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        inDegree[b]++;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.fill(he, -1);
        for (int[] pre : prerequisites) {
            add(pre[1], pre[0]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.addLast(i);
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            ans++;
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--inDegree[j] == 0) {
                    deque.addLast(j);
                }
            }
        }
        return ans == numCourses;
    }
}