package review.zhousai.leetcode6149;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] edges = {2, 0, 0, 2};
        System.out.println(solution.edgeScore(edges));
    }

    public int edgeScore(int[] edges) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < edges.length; i++) {
//            map.put(edges[i], map.getOrDefault(edges[i], 0) + i);
//        }
//        return map.entrySet().stream().min((a, b) -> {
//            if (!a.getValue().equals(b.getValue())) {
//                return b.getValue() - a.getValue();
//            } else {
//                return a.getKey() - b.getKey();
//            }
//        }).get().getKey();
        long[] sums = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            sums[edges[i]] += i;
        }
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            if (sums[i] > sums[max]) {
                max = i;
            }
        }
        return max;
    }
}