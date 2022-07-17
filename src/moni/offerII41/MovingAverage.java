package moni.offerII41;

import java.util.ArrayList;
import java.util.List;

class MovingAverage {

    int size, idx = 0;
    List<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        int sum = 0;
        idx++;
        list.add(val);
        int right = idx - 1, left = idx >= size ? idx - size : 0;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            cnt++;
            sum += list.get(i);
        }
        return (double) sum / (Math.min(cnt, size));
    }
}