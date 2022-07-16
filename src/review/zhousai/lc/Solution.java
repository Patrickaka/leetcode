package review.zhousai.lc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Map<Integer, Integer> h_map = new HashMap<>();
        Map<Integer, Integer> t_map = new HashMap<>();
        Queue<Integer> h_queue = new LinkedList<>();
        Queue<Integer> t_queue = new LinkedList<>();
        h_queue.offer(start);
        t_queue.offer(goal);
        h_map.put(start, 0);
        t_map.put(goal, 0);
        while (!h_queue.isEmpty() || !t_queue.isEmpty()) {
            if (!h_queue.isEmpty()) {
                System.out.println("1");
                int h_poll = h_queue.poll();
                int h_step = h_map.get(h_poll);
//                    if (h_poll >= 0 && h_poll <= 1000) {
                for (int num : nums) {
                    int[] h_arr = new int[]{h_poll ^ num, h_poll - num, h_poll + num};
                    for (int j = 0; j < 3; j++) {
                        if (t_map.containsKey(h_arr[j])) {
                            return t_map.get(h_arr[j]) + h_step + 1;
                        }
                        if (!h_map.containsKey(h_arr[j])) {
                            if (h_arr[j] >= 0 && h_arr[j] <= 1000) {
                                h_queue.offer(h_arr[j]);
                            }
                            h_map.put(h_arr[j], h_step + 1);
                        }
                    }
                }
//                    }
            }
            if (!t_queue.isEmpty()) {
                int t_poll = t_queue.poll();
                int t_step = t_map.get(t_poll);
//                    if (t_poll >= 0 && t_poll <= 1000) {
                for (int num : nums) {
                    int[] t_arr = new int[]{t_poll ^ num, t_poll - num, t_poll + num};
                    for (int j = 0; j < 3; j++) {
//                                if (t_arr[j] < 0 || t_arr[j] > 1000)
//                                    continue;
                        if (h_map.containsKey(t_arr[j])) {
                            return h_map.get(t_arr[j]) + t_step + 1;
                        }
                        if (!t_map.containsKey(t_arr[j])) {
                            if (t_arr[j] >= 0 && t_arr[j] <= 1000) {
                                t_queue.offer(t_arr[j]);
                            }
                            t_map.put(t_arr[j], t_step + 1);
                        }
                    }
                }
//                    }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {81, -5, 22, -57, 9, -97, 95, 80, 5, -4, -74, 77, -63, 93, 70, -56, 35, -79, -31, -75, 23, 24, -73, -43, -25, -35, -94, 25, 89, 41, 94, 61, -24, -16, 49, -44, 4, -92, -100, 30, -52, -33, 47, 68, -53, 78, -2, 11, 39, -20, 44, 34, -8, -22, 99, -86, -40, 2, -90, -85, 14, -14, -99, -84, 55, 28, 8, -88, -62, 88, -38, 38, 15, -6, 45, 73, 72, 90, 84, 16, -69, 21, -89, 29, 57, -15, 50, 27, -18, -60, -70, 31, 52, 85};
        int start = 62, goal = 936;
        System.out.println(s.minimumOperations(arr, start, goal));
    }
}