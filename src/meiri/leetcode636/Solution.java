package meiri.leetcode636;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("1:start:7");
        list.add("1:end:7");
        list.add("0:end:8");
        System.out.println(Arrays.toString(solution.exclusiveTime(2, list)));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        String[] prev = logs.get(0).split(":");
        deque.addLast(Integer.parseInt(prev[0]));
        for (int i = 1; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int prevIdx = Integer.parseInt(prev[0]);
            int prevTime = Integer.parseInt(prev[2]);
            int idx = Integer.parseInt(log[0]);
            int time = Integer.parseInt(log[2]);
            if ("end".equals(log[1]) && "end".equals(prev[1])) {
                ans[idx] += time - prevTime;
            } else if ("end".equals(log[1]) && "start".equals(prev[1])) {
                ans[idx] += time - prevTime + 1;
            } else if ("start".equals(log[1]) && "start".equals(prev[1])) {
                ans[prevIdx] += time - prevTime;
            } else if ("start".equals(log[1]) && "end".equals(prev[1]) && !deque.isEmpty()) {
                ans[deque.peekLast()] += time - prevTime - 1;
            }
            if ("start".equals(log[1])) {
                deque.addLast(Integer.parseInt(log[0]));
            }
            if ("end".equals(log[1])) {
                deque.pollLast();
            }
            prev = log;
        }
        return ans;
    }
}