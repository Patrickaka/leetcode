//给你一个长度为 n 下标从 0 开始的整数数组 nums 。 
//
// 我们想将下标进行分组，使得 [0, n - 1] 内所有下标 i 都 恰好 被分到其中一组。 
//
// 如果以下条件成立，我们说这个分组方案是合法的： 
//
// 
// 对于每个组 g ，同一组内所有下标在 nums 中对应的数值都相等。 
// 对于任意两个组 g1 和 g2 ，两个组中 下标数量 的 差值不超过 1 。 
// 
//
// 请你返回一个整数，表示得到一个合法分组方案的 最少 组数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3,2,3]
//输出：2
//解释：一个得到 2 个分组的方案如下，中括号内的数字都是下标：
//组 1 -> [0,2,4]
//组 2 -> [1,3]
//所有下标都只属于一个组。
//组 1 中，nums[0] == nums[2] == nums[4] ，所有下标对应的数值都相等。
//组 2 中，nums[1] == nums[3] ，所有下标对应的数值都相等。
//组 1 中下标数目为 3 ，组 2 中下标数目为 2 。
//两者之差不超过 1 。
//无法得到一个小于 2 组的答案，因为如果只有 1 组，组内所有下标对应的数值都要相等。
//所以答案为 2 。 
//
// 示例 2： 
//
// 
//输入：nums = [10,10,10,3,1,1]
//输出：4
//解释：一个得到 2 个分组的方案如下，中括号内的数字都是下标：
//组 1 -> [0]
//组 2 -> [1,2]
//组 3 -> [3]
//组 4 -> [4,5]
//分组方案满足题目要求的两个条件。
//无法得到一个小于 4 组的答案。
//所以答案为 4 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 哈希表 👍 28 👎 0

package meiri.leetcode.editor.cn;
public class MinimumNumberOfGroupsToCreateAValidAssignment{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfGroupsToCreateAValidAssignment().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}