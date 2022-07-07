package moni.leetcode1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int min = (int) 1e6 + 10;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < min) {
                min = arr[i] - arr[i - 1];
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + min == arr[i + 1]) {
                List<Integer> diff = new ArrayList<>();
                diff.add(arr[i]);
                diff.add(arr[i + 1]);
                result.add(diff);
            }
        }
        return result;
    }
}