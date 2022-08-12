package offer.offer53I;

class Solution {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        System.out.println(solution.search(arr, 8));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans = 0;
        for (int i = r; i >= 0; i--) {
            if (nums[i] < target) {
                break;
            }
            if (nums[i] == target) {
                ans++;
            }
        }
        return ans;
    }
}