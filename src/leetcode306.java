import java.util.ArrayList;
import java.util.List;

class Solution306 {

    String nums;
    int n;
    List<List<Integer>> list = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        nums = num;
        n = num.length();
        return dfs(0);
    }

    boolean dfs(int u) {
        int m = list.size();
        if (u == n) {
            return m >= 3;
        }
        int max = nums.charAt(u) == '0' ? u + 1 : n;
        List<Integer> cur = new ArrayList<>();
        for (int i = u; i < max; i++) {
            cur.add(0, nums.charAt(i) - '0');
            if (m < 2 || check(list.get(m - 2), list.get(m - 1), cur)) {
                list.add(cur);
                if (dfs(i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> ans = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) {
                t += a.get(i);
            }
            if (i < b.size()) {
                t += b.get(i);
            }
            ans.add(t % 10);
            t /= 10;
        }
        if (t > 0) {
            ans.add(t);
        }
        boolean flag = c.size() == ans.size();
        for (int i = 0; i < c.size() && flag; i++) {
            if (!c.get(i).equals(ans.get(i))) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String num = "199100199";
        boolean ans = s.isAdditiveNumber(num);
        System.out.println(ans);
    }
}