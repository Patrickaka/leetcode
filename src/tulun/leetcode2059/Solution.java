package tulun.leetcode2059;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {

    int[] nums;

    public static void main(String[] args) {
        int[] _nums = {2, 8, 16};
        int start = 0, goal = 1;
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations(_nums, start, goal));
    }

    public int minimumOperations(int[] _nums, int start, int goal) {
        nums = _nums;
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        d1.addLast(start);
        map1.put(start, 0);
        d2.addLast(goal);
        map2.put(goal, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int ans;
            if (d1.size() <= d2.size()) {
                ans = update(d1, map1, map2);
            } else {
                ans = update(d2, map2, map1);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    int update(Deque<Integer> d1, Map<Integer, Integer> source, Map<Integer, Integer> target) {
        int size = d1.size();
        for (int i = 0; i < size; i++) {
            int poll = d1.pollFirst();
            int step = source.get(poll);
            for (int num : nums) {
                int a = poll + num, b = poll - num, c = poll ^ num;
                if (add(a, step, d1, source, target)) {
                    return step + 1 + target.get(a);
                }
                if (add(b, step, d1, source, target)) {
                    return step + 1 + target.get(b);
                }
                if (add(c, step, d1, source, target)) {
                    return step + 1 + target.get(c);
                }
            }
        }
        return -1;
    }

    boolean check(int num) {
        return num >= 0 && num <= 1000;
    }

    boolean add(int num, int step, Deque<Integer> d1, Map<Integer, Integer> source, Map<Integer, Integer> target) {
        //System.out.println(num);
        if (target.containsKey(num)) {
            return true;
        } else {
            if (!source.containsKey(num) && check(num)) {
                d1.addLast(num);
                source.put(num, step + 1);
            }
            return false;
        }
    }
}