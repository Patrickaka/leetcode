package zhousai.danzhou301.t3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canChange(String start, String target) {
        List<Character> c1 = new ArrayList<>(), c2 = new ArrayList<>();
        List<Integer> d1 = new ArrayList<>(), d2 = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                c1.add(start.charAt(i));
                d1.add(i);
            }
            if (target.charAt(i) != '_') {
                c2.add(target.charAt(i));
                d2.add(i);
            }
        }
        int n1 = c1.size(), n2 = c2.size();
        if (n1 != n2) {
            return false;
        }
        for (int i = 0; i < n1; i++) {
            if (!c1.get(i).equals(c2.get(i))) {
                return false;
            }
            if (c1.get(i) == 'L' && d1.get(i) < d2.get(i)) {
                return false;
            }
            if (c1.get(i) == 'R' && d1.get(i) > d2.get(i)) {
                return false;
            }
        }
        return true;
    }
}