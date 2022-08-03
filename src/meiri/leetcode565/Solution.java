package meiri.leetcode565;

class Solution {

    int[] nums;
    boolean[] vis;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(solution.arrayNesting(nums));
    }

    public int arrayNesting(int[] nums) {
        this.nums = nums;
        vis = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = getMax(i);
            if (t > max) {
                max = t;
            }
        }
        return max;
    }

    int getMax(int x) {
        int cur = nums[x];

        int idx = 0;
        while (!vis[cur]) {
            vis[cur] = true;
            cur = nums[cur];
            idx++;
        }
        return idx;
    }
}