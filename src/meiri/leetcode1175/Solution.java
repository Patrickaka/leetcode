package meiri.leetcode1175;


import java.util.ArrayList;
import java.util.List;

class Solution1175 {

    static int MOD = (int) 1e9 + 7;
    static List<Integer> list = new ArrayList<>();

    static {
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                list.add(i);
            }
        }
    }

    public static int numPrimeArrangements(int n) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid) <= n) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int a = r + 1, b = n - a;
        long ans = 1;
        for (int i = a; i > 1; i--) {
            ans = ans * i % MOD;
        }
        for (int i = b; i > 1; i--) {
            ans = ans * i % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(numPrimeArrangements(n));
    }
}