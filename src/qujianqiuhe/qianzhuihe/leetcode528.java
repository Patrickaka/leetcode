package qujianqiuhe.qianzhuihe;

class Solution528 {

    int N;
    int[] sums;

    public Solution528(int[] w) {
        N = w.length;
        sums = new int[N + 10];
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int random = (int) (Math.random() * sums[N]) + 1;
        int l = 1, r = N;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (sums[mid] < random) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return sums[r] < random ? r : r - 1;
    }
}

