package review.zhousai.leetcode6136;

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int d1 = nums[i] + diff;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == d1) {
                    int d2 = nums[j] + diff;
                    boolean ok = false;
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] == d2) {
                            ans++;
                            ok = true;
                            break;
                        } else if (nums[k] > d2) {
                            ok = true;
                            break;
                        }
                    }
                    if (ok) {
                        break;
                    }
                } else if (nums[j] > d1) {
                    break;
                }
            }
        }
        return ans;
    }
}