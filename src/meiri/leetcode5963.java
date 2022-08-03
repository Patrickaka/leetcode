package meiri;

import java.util.*;

class Solution5963 {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        long[] ans = new long[n];
        Arrays.fill(ans, 0);
        for (int i = 0; i < n; i++) {
            List<Integer> temp = map.getOrDefault(arr[i], new ArrayList<>());
            if (temp.size() != 0) {
                int finalI = i;
                temp.forEach(num -> {
                    ans[finalI] += Math.abs(finalI - num);
                    ans[num] += Math.abs(finalI - num);
                });
            }
            temp.add(i);
            map.put(arr[i], temp);
        }
        return ans;
    }
}