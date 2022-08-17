package meiri.leetcode1224;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}));
    }

    public int maxEqualFreq(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] times = new int[(int) 1e5 + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (times[num] != 0) {
                if (map.get(times[num]) == 1) {
                    map.remove(times[num]);
                } else {
                    map.put(times[num], map.get(times[num]) - 1);
                }
            }
            times[num]++;
            map.put(times[num], map.getOrDefault(times[num], 0) + 1);
            if (map.size() == 2) {
                int a = map.firstKey(), b = map.lastKey();
                if (a == 1 && map.get(a) == 1) {
                    list.add(i + 1);
                    continue;
                } else if (a + 1 == b && map.get(b) == 1) {
                    list.add(i + 1);
                    continue;
                }
            }
            if (map.size() == 1) {
                int a = map.firstKey();
                if (a == 1 || map.get(a) == 1) {
                    list.add(i + 1);
                }
            }
        }
        return list.size() == 0 ? 1 : list.get(list.size() - 1);
    }
}