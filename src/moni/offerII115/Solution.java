package moni.offerII115;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    static int M = (int) 1e4 + 10, N = (int) 1e5 + 10, idx = 0;
    int[] he = new int[M], ne = new int[N], e = new int[N], inDegree = new int[M];

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3};
        int[][] sequences = {{1, 2}, {1, 3}, {2, 3}, {4, 2}};
        Solution solution = new Solution();
        System.out.println(solution.sequenceReconstruction(nums, sequences));
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        inDegree[b]++;
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Arrays.fill(he, -1);
        int n = nums.length;
        for (int[] s : sequences) {
            for (int i = 1; i < s.length; i++) {
                add(s[i - 1], s[i]);
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                deque.addLast(i);
            }
        }
        int cnt = 0;
        while (!deque.isEmpty()) {
            if (deque.size() != 1) {
                return false;
            }
            int poll = deque.poll();
            if (nums[cnt++] != poll) {
                return false;
            }
            for (int i = he[poll]; i != -1; i = ne[i]) {
                if (--inDegree[e[i]] == 0) {
                    deque.addLast(e[i]);
                }
            }
        }
        return true;
    }
}