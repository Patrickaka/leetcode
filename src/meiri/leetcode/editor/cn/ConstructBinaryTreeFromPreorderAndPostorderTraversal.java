//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 343 👎 0

package meiri.leetcode.editor.cn;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //根-左-右
        //左-右-根
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            TreeNode treeNode = new TreeNode();
            int n = preorder.length;
            treeNode.val = preorder[0];
            int index = -1;
            if (n != 1) {
                for (int i = 0; i < n; i++) {
                    if (postorder[i] == preorder[1]) {
                        index = i;
                        break;
                    }
                }
            }
            if (index != -1) {
                treeNode.left = constructFromPrePost(Arrays.copyOfRange(preorder, 1, index + 2), Arrays.copyOfRange(postorder, 0, index + 1));
            }
            if (index + 1 != n - 1) {
                treeNode.right = constructFromPrePost(Arrays.copyOfRange(preorder, index + 2, n), Arrays.copyOfRange(postorder, index + 1, n - 1));
            }
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}