package tulun.leetcode954;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {

    int[] cnts = new int[M * 2], in = new int[M * 2];
    static int N = (int) 1e5 + 10, M = N * 2;
    List<Integer> list = new ArrayList<>();

    public boolean canReorderDoubled(int[] arr) {
        for (int i : arr) {
            if (cnts[i + M]++ == 0 && i != 0) {
                list.add(i);
            }
        }
        if (cnts[M] % 2 != 0) {
            return false;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : list) {
            if (i % 2 == 0) {
                in[i + M] = cnts[i / 2 + M];
                if (in[i + M] == 0) {
                    deque.addLast(i);
                }
            } else {
                deque.addLast(i);
            }
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst(), t = poll * 2;
            if (cnts[t + M] < cnts[poll + M]) {
                return false;
            }
            cnts[t + M] -= cnts[poll + M];
            in[t + M] -= cnts[poll + M];
            if (in[t + M] == 0 && cnts[t + M] != 0) {
                deque.add(t);
            }
            in[t * 2 + M] -= cnts[poll + M];
            if (in[t * 2 + M] == 0 && cnts[t * 2 + M] != 0) {
                deque.add(t * 2);
            }
        }
        return true;
    }


}