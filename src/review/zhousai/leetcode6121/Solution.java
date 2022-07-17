package review.zhousai.leetcode6121;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums = {"24", "37", "96", "04"};
        int[][] queries = {{2, 1}, {2, 2}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums, queries)));
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int m = queries.length, idx = 0;
        int[] ans = new int[m];
        Map<Integer, List<String>> map = new HashMap<>();
        Map<Integer, Map<String, List<Integer>>> map2 = new HashMap<>();
        int length = nums[0].length();
        for (int[] query : queries) {
            List<String> list;
            if (!map.containsKey(query[1])) {
                list = new ArrayList<>();
                for (String num : nums) {
                    list.add(num.substring(length - query[1]));
                }
                map.put(query[1], list);
            } else {
                list = map.get(query[1]);
            }
            Map<String, List<Integer>> m2;
            if (!map2.containsKey(query[1])) {
                m2 = new HashMap<>();
                for (int i = 0; i < list.size(); i++) {
                    List<Integer> l1 = m2.getOrDefault(list.get(i), new ArrayList<>());
                    l1.add(i);
                    m2.put(list.get(i), l1);
                }
                map2.put(query[1], m2);
            } else {
                m2 = map2.get(query[1]);
            }
            List<String> collect = list.stream().sorted().collect(Collectors.toList());
            String cnt = collect.get(query[0] - 1);
            int a = 0;
            for (int i = 0; i < query[0] - 1; i++) {
                if (Objects.equals(collect.get(i), cnt)) {
                    a++;
                }
            }
            List<Integer> l2 = m2.get(cnt);
            ans[idx++] = l2.get(a);
        }
        return ans;
    }
}