package zhousai.shuangzhou83.t4;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> s = new HashSet<>();
        int z = 0;
        for (int i : rolls) {
            s.add(i);
            if (s.size() == k) {
                s.clear();
                z++;
            }
        }
        return z + 1;
    }
}