class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int ans, max = 0, n = piles.length;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        int l = 0, r = max + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, piles, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int m, int[] piles, int h) {
        int times = 0;
        for (int pile : piles) {
            times += Math.ceil(pile * 1.0 / m);
        }
        return times <= h;
    }
}