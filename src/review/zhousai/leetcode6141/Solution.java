package review.zhousai.leetcode6141;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            int t = map.getOrDefault(item[0], 0);
            map.put(item[0], t + item[1]);
        }
        for (int[] item : items2) {
            int t = map.getOrDefault(item[0], 0);
            map.put(item[0], t + item[1]);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer integer : collect) {
            List<Integer> list = new ArrayList<>();
            list.add(integer);
            list.add(map.get(integer));
            res.add(list);
        }
        return res;
    }
}