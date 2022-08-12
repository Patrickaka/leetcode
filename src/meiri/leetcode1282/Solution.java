package meiri.leetcode1282;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] group = {2, 1, 3, 3, 3, 2};
        System.out.println(solution.groupThePeople(group));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int cnt = list.size() / entry.getKey();
            int idx = 0;
            for (int i = 0; i < cnt; i++) {
                List<Integer> l1 = new ArrayList<>();
                for (int j = 0; j < entry.getKey(); j++) {
                    l1.add(list.get(idx++));
                }
                ans.add(l1);
            }
        }
        return ans;
    }
}