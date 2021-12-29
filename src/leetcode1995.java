class Solution {
    public static int countQuadruplets1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static int countQuadruplets2(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int c = n - 2; c >= 2; c--) {
            cnt[nums[c + 1]]++;
            for (int a = 0; a < n - 3; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += cnt[nums[a] + nums[b] + nums[c]];
                }
            }
        }
        return ans;
    }

    public static int countQuadruplets3(int[] nums) {
        int n = nums.length, ans = 0;
        int[] cnt = new int[10010];
        for (int b = n - 3; b >= 1; b--) {
            for (int d = n - 1; d >= b + 2; d--) {
                cnt[nums[d] - nums[b + 1] + 200]++;
            }
            for (int a = 0; a < b; a++) {
                ans += cnt[nums[a] + nums[b] + 200];
            }
        }
        return ans;
    }

    public static int countQuadruplets(int[] nums) {
        int n = nums.length, ans = 0;

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 5};
        int ans = countQuadruplets3(nums);
        System.out.println(ans);
    }
}