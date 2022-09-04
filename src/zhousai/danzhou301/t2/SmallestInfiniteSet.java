package zhousai.danzhou301.t2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {

    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    Set<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {
        for (int i = 1; i <= 1000; i++) {
            q.add(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        int ans = q.poll();
        set.remove(ans);
        return ans;
    }

    public void addBack(int num) {
        if (!set.contains(num)) {
            q.add(num);
            set.add(num);
        }
    }
}
