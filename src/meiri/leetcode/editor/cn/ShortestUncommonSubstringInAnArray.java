//给你一个数组 arr ，数组中有 n 个 非空 字符串。 
//
// 请你求出一个长度为 n 的字符串 answer ，满足： 
//
// 
// answer[i] 是 arr[i] 最短 的子字符串，且它不是 arr 中其他任何字符串的子字符串。如果有多个这样的子字符串存在，answer[i] 应
//该是它们中字典序最小的一个。如果不存在这样的子字符串，answer[i] 为空字符串。 
// 
//
// 请你返回数组 answer 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = ["cab","ad","bad","c"]
//输出：["ab","","ba",""]
//解释：求解过程如下：
//- 对于字符串 "cab" ，最短没有在其他字符串中出现过的子字符串是 "ca" 或者 "ab" ，我们选择字典序更小的子字符串，也就是 "ab" 。
//- 对于字符串 "ad" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "bad" ，最短没有在其他字符串中出现过的子字符串是 "ba" 。
//- 对于字符串 "c" ，不存在没有在其他字符串中出现过的子字符串。
// 
//
// 示例 2： 
//
// 
//输入：arr = ["abc","bcd","abcd"]
//输出：["","","abcd"]
//解释：求解过程如下：
//- 对于字符串 "abc" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "bcd" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "abcd" ，最短没有在其他字符串中出现过的子字符串是 "abcd" 。
// 
//
// 
//
// 提示： 
//
// 
// n == arr.length 
// 2 <= n <= 100 
// 1 <= arr[i].length <= 20 
// arr[i] 只包含小写英文字母。 
// 
//
// 👍 2 👎 0

package meiri.leetcode.editor.cn;

import java.util.*;

public class ShortestUncommonSubstringInAnArray {
    public static void main(String[] args) {
        Solution solution = new ShortestUncommonSubstringInAnArray().new Solution();
        String[] strings = solution.shortestSubstrings(new String[]{"ab"});
        System.out.println(Arrays.toString(strings));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] shortestSubstrings(String[] arr) {
            String[] res = new String[arr.length];
            List<HashSet<String>> setsList = new ArrayList<>();
            for (String s : arr) {
                HashSet<String> set = new HashSet<>();
                int n = 1;
                while (n <= s.length()) {
                    for (int i = 0; i + n <= s.length(); i++) {
                        set.add(s.substring(i, i + n));
                    }
                    n++;
                }
                setsList.add(set);
            }
            for (int i = 0; i < arr.length; i++) {
                int n = 1;
                String curRes = "";
                while (n <= arr[i].length()) {
                    for (int k = 0; k + n <= arr[i].length(); k++) {
                        String curS = arr[i].substring(k, k + n);
                        boolean flag = true;
                        for (int j = 0; j < arr.length; j++) {
                            if (i != j) {
                                Set<String> curSet = setsList.get(j);
                                if (curSet.contains(curS)) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag) {
                            continue;
                        } else {
                            if (curRes.isEmpty()) {
                                curRes = curS;
                            } else {
                                curRes = curRes.compareTo(curS) < 0 ? curRes : curS;
                            }
                        }
                    }
                    if (!curRes.equals("")) {
                        break;
                    }
                    n++;
                }
                res[i] = curRes;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}