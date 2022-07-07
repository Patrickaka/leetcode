package moni.leetcode556;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> elements = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 23;
        System.out.println(solution.nextGreaterElement(n));
    }

    public int nextGreaterElement(int n) {
        while (n != 0) {
            elements.add(n % 10);
            n /= 10;
        }
        int count = elements.size(), idx = -1;
        for (int i = 0; i < count - 1 && idx == -1; i++) {
            if (elements.get(i + 1) < elements.get(i)) {
                idx = i + 1;
            }
        }
        if (idx == -1) {
            return -1;
        }
        for (int i = 0; i < idx; i++) {
            if (elements.get(i) > elements.get(idx)) {
                swap(i, idx);
                break;
            }
        }
        for (int l = 0, r = idx - 1; l < r; l++, r--) {
            swap(l, r);
        }
        long ans = 0;
        for (int i = count - 1; i >= 0; i--) {
            ans = ans * 10 + elements.get(i);
        }
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    void swap(int start, int end) {
        int c = elements.get(start);
        elements.set(start, elements.get(end));
        elements.set(end, c);
    }
}