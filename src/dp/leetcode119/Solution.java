package dp.leetcode119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int a, b;
                if (j == 0) {
                    a = 0;
                    b = row.get(0);
                } else if (j == i - 1) {
                    a = row.get(j - 1);
                    b = 0;
                } else {
                    a = row.get(j - 1);
                    b = row.get(j);
                }
                list.add(a + b);
            }
            row = list;
        }
        return row;
    }
}