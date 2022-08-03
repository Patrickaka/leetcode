package meiri;

import java.util.PriorityQueue;

class Solution1405 {
    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) {
            q.add(new int[]{0, a});
        }
        if (b > 0) {
            q.add(new int[]{1, b});
        }
        if (c > 0) {
            q.add(new int[]{2, c});
        }
        return null;
    }

    public static void main(String[] args) {
        String s = longestDiverseString(1, 1, 7);
    }
}