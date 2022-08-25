package offer.offerII115;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    int N = (int) 1e4 + 1, M = (int) 1e5, idx = 0;

    int[] he = new int[N], ne = new int[M], e = new int[M], indegree = new int[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        indegree[b]++;
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        Arrays.fill(he, -1);
        for (int[] s : sequences) {
            for (int i = 0; i < s.length - 1; i++) {
                add(s[i], s[i + 1]);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                deque.addLast(i);
            }
        }
        idx = 0;
        while (!deque.isEmpty()) {
            if (deque.size() != 1) {
                return false;
            }
            int poll = deque.pollFirst();
            if (poll != nums[idx++]) {
                return false;
            }
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--indegree[j] == 0) {
                    deque.addLast(j);
                }
            }
        }
        return true;
    }
}