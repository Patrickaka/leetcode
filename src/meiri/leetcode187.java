package meiri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution187 {


    public static List<String> findRepeatedDnaSequences(String s) {
        int N = (int) (1e5 + 10);
        int P = 131313;
        int[] h = new int[N], p = new int[N];
        List<String> ans = new ArrayList<>();
        int n = s.length();
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i + 10 - 1 <= n; i++) {
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) {
                ans.add(s.substring(i - 1, i + 10 - 1));
            }
            map.put(hash, cnt + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> ans = findRepeatedDnaSequences(s);
        System.out.println(ans);
    }
}