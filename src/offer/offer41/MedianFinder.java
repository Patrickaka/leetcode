package offer.offer41;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> l = new PriorityQueue<>((a, b) -> (b - a));
    PriorityQueue<Integer> r = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (l.size() == r.size()) {
            if (r.size() == 0 || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.poll());
                r.add(num);
            }
        } else if (l.size() > r.size()) {
            if (num > l.peek()) {
                r.add(num);
            } else {
                r.add(l.poll());
                l.add(num);
            }
        } else {
            if (num <= r.peek()) {
                l.add(num);
            } else {
                r.add(l.poll());
                r.add(num);
            }
        }
    }

    public double findMedian() {
        int a = l.size(), b = r.size();
        if (a != 0 && a == b) {
            return (l.peek() + r.peek()) / 2.0;
        } else if (a > b) {
            return l.peek();
        } else {
            return r.peek();
        }
    }
}