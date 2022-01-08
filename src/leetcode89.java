import java.util.ArrayList;
import java.util.List;

class Solution89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        while (n-- > 0) {
            int m = ans.size();
            for (int i = m - 1; i >= 0; i--) {
                ans.set(i, ans.get(i) << 1);
                ans.add(ans.get(i) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        List<Integer> ans = grayCode(n);
        System.out.println(ans);
    }
}