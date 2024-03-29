//给你一个 正整数 数组 nums 。 
//
// 你需要从数组中选出一个满足下述条件的子集： 
//
// 
// 你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x², x⁴, ..., xᵏ/², xᵏ, xᵏ/², ..., x⁴
//, x², x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4, 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 
//8, 4, 2] 则不符合。 
// 
//
// 返回满足这些条件的子集中，元素数量的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,4,1,2,2]
//输出：3
//解释：选择子集 {4,2,2} ，将其放在数组 [2,4,2] 中，它遵循该模式，且 2² == 4 。因此答案是 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,4]
//输出：1
//解释：选择子集 {1}，将其放在数组 [1] 中，它遵循该模式。因此答案是 1 。注意我们也可以选择子集 {2} 、{4} 或 {3} ，可能存在多个子集都
//能得到相同的答案。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 枚举 👍 6 👎 0

package meiri.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheMaximumNumberOfElementsInSubset {
    public static void main(String[] args) {
        Solution solution = new FindTheMaximumNumberOfElementsInSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums) {
            int res = 0;
            Set<Integer> twoSet = new HashSet<>();
            int sum = 1;
            for (int i = 0; i < nums.length; i++) {
                twoSet.add(sum);
                sum *= 2;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int start : map.keySet()) {
                int cur = start;
                int cnt = 0;
                int k = 1;
                while (map.containsKey(cur)) {
                    if (cur == 1) {
                        if (map.get(1) % 2 == 0) {
                            cnt = map.get(1) / 2;
                        } else {
                            cnt = (map.get(1) + 1)/ 2;
                        }
                        break;
                    }
                    cnt++;
                    if (map.get(cur) < 2) {
                        break;
                    }
                    cur *= cur;
                    k *= 2;
                }
                if (twoSet.contains(k)) {
                    res = Math.max(res, cnt * 2 - 1);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}