package meiri.leetcode1413;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStartValue(new int[]{2, 5, 5, -5, -1}));
    }

    public int minStartValue(int[] nums) {
        int sum = 0, min = 101;
        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }
        return min <= 0 ? Math.abs(min) + 1 : 1;
    }
}