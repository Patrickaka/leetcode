package dp.leetcode118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(4));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int a, b;
                if (j == 0) {
                    a = 0;
                    b = result.get(i - 2).get(0);
                } else if (j == i - 1) {
                    a = result.get(i - 2).get(j - 1);
                    b = 0;
                } else {
                    a = result.get(i - 2).get(j - 1);
                    b = result.get(i - 2).get(j);
                }
                list.add(a + b);
            }
            result.add(list);
        }
        return result;
    }
}