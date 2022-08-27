package meiri.leetcode793;

class Solution {
    public int preimageSizeFZF(int k) {
        long l = 0, r = 5L * k;
        while (l < r) {
            long mid = l + r >> 1;
            if (calc(mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long l1 = 0, r1 = 5L * (k + 1);
        while (l1 < r1) {
            long mid = l1 + r1 >> 1;
            if (calc(mid) >= k + 1) {
                r1 = mid;
            } else {
                l1 = mid + 1;
            }
        }
        return (int) (r1 - r);
    }

    private long calc(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }

}