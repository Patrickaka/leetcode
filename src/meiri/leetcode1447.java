package meiri;

import java.util.ArrayList;
import java.util.List;

class Solution1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (check(i, j)) {
                    continue;
                }
                ans.add(j + "/" + i);
            }
        }
        return ans;
    }

    private boolean check(int i, int j) {
        if (j == 1) {
            return false;
        }
        for (int a = 2; a <= j; a++) {
            if (i % a == 0 && j % a == 0) {
                return true;
            }
        }
        return false;
    }
}