package meiri.leetcode658;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        Deque<Integer> ans = new ArrayDeque<>();
        int left, right;
        if (arr[r] == x) {
            ans.add(arr[r]);
            left = r - 1;
        } else {
            left = r;
        }
        right = r + 1;
        while (ans.size() != k) {
            if (left >= 0 && right < n) {
                if (Math.abs(x - arr[left]) > Math.abs(x - arr[right])) {
                    ans.addLast(arr[right]);
                    right++;
                } else if (Math.abs(x - arr[left]) < Math.abs(x - arr[right])) {
                    ans.addFirst(arr[left]);
                    left--;
                } else {
                    ans.addFirst(arr[left]);
                    left--;
                }
            } else if (left < 0) {
                ans.addLast(arr[right]);
                right++;
            } else {
                ans.addFirst(arr[left]);
                left--;
            }
        }
        return new ArrayList<>(ans);
    }
}