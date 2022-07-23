package review.zhousai.leetcode6130;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class NumberContainers {

    static int N = (int) 1e9 + 10;
    Map<Integer, Integer> nums = new HashMap<>();
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();

    public NumberContainers() {
    }

    public void change(int index, int number) {
        if (!nums.containsKey(index)) {
            nums.put(index, number);
            TreeSet<Integer> s = map.getOrDefault(number, new TreeSet<>());
            s.add(index);
            map.put(number, s);
        } else {
            int temp = nums.get(index);
            TreeSet<Integer> s1 = map.getOrDefault(temp, new TreeSet<>());
            s1.remove(index);
            map.put(temp, s1);
            nums.put(index, number);
            TreeSet<Integer> s2 = map.getOrDefault(number, new TreeSet<>());
            s2.add(index);
            map.put(number, s2);
        }
    }

    public int find(int number) {
        if (!map.containsKey(number)) {
            return -1;
        }
        if (map.get(number).size() == 0) {
            return -1;
        }
        return map.get(number).first();
    }
}
