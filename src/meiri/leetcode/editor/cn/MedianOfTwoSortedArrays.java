//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7036 👎 0

package meiri.leetcode.editor.cn;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[] arr = new int[m + n];
            int l1 = 0, l2 = 0, cnt = 0;
            while (l1 < m && l2 < n) {
                if (nums1[l1] <= nums2[l2]) {
                    arr[cnt++] = nums1[l1++];
                } else {
                    arr[cnt++] = nums2[l2++];
                }
            }
            while (l1 < m) {
                arr[cnt++] = nums1[l1++];
            }
            while (l2 < n) {
                arr[cnt++] = nums2[l2++];
            }
            System.out.println(Arrays.toString(arr));
            if ((m + n) % 2 == 0) {
                return (double) (arr[(m + n) / 2] + arr[(m + n) / 2 - 1]) / 2d;
            } else {
                return arr[(m + n) / 2];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}