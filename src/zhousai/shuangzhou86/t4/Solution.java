package zhousai.shuangzhou86.t4;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0, n = chargeTimes.length;
        int left = 0, right = 0;
        int cost = 0, maxv = 0, sum = 0;
        while (left < n && right <= n) {
            if (cost < budget) {
                right++;
                if (right > n) {
                    break;
                }
                maxv = Math.max(maxv, chargeTimes[right - 1]);
                sum += runningCosts[right - 1];
                cost = maxv + (right - left) * sum;
                if (cost <= budget) {
                    ans = Math.max(ans, right - left);
                } else {
                    ++left;
                    if (left >= n) {
                        break;
                    }
                    sum -= runningCosts[left - 1];
                    maxv = 0;
                    for (int i = left; i < right; i++) {
                        maxv = Math.max(maxv, chargeTimes[i]);
                    }
                    cost = maxv + (right - left) * sum;
                }
            }
        }
        return ans;
    }
}