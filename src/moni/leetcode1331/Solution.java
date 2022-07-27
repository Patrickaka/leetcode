package moni.leetcode1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int idx = 1;
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(result[i])) {
                map.put(result[i], idx++);
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}