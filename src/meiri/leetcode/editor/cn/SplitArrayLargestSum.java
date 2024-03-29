//给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。 
//
// 设计一个算法使得这 k 个子数组各自和的最大值最小。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [7,2,5,10,8], k = 2
//输出：18
//解释：
//一共有四种方法将 nums 分割为 2 个子数组。 
//其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5], k = 2
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,4], k = 3
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= min(50, nums.length) 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 前缀和 👍 950 👎 0

package meiri.leetcode.editor.cn;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
        int res = solution.splitArray(new int[]{1, 4, 4}, 3);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {
            int sum = 0, mx = 0;
            for (int num : nums) {
                sum += num;
                mx = Math.max(mx, num);
            }
            int l = Math.max(mx - 1, (sum - 1) / k), r = sum;
            while (l < r) {
                int mid = l + r >> 1;
                //check=true, 说明nums[mid] >= target的,
                if (check(nums, k, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public boolean check(int[] nums, int k, int mx) {
            int cnt = 1;
            int s = 0;
            for (int x : nums) {
                if (x > mx) {
                    return false;
                }
                if (s + x <= mx) {
                    s += x;
                } else {
                    if (cnt == k) {
                        return false;
                    }
                    cnt += 1;
                    s = x;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}