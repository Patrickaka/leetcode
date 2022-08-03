package meiri;

import java.util.*;

class Solution954 {
    static int N = 100010, M = N * 2;
    static int[] cnts = new int[M * 2];

    public boolean canReorderDoubled1(int[] arr) {
        Arrays.fill(cnts, 0);
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
        for (int i : arr) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int x = q.poll(), t = x * 2;
            if (cnts[x + M] != 0 && --cnts[x + M] >= 0) {
                continue;
            }
            cnts[t + M]++;
        }
        for (int i = 0; i < M * 2; i++) {
            if (cnts[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canReorderDoubled2(int[] arr) {
        Arrays.fill(cnts, 0);
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (++cnts[i + M] == 1) {
                list.add(i);
            }
        }
        list.sort(Comparator.comparingInt(Math::abs));
        for (int i : list) {
            if (cnts[i + M] < cnts[2 * i + M]) {
                return false;
            }
        }
        return true;
    }


}