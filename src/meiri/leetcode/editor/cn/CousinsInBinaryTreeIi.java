//给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。 
//
// 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。 
//
// 请你返回修改值之后，树的根 root 。 
//
// 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,9,1,10,null,7]
//输出：[0,0,0,7,7,null,11]
//解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
//- 值为 5 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 4 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 9 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
//- 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
//- 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [3,1,2]
//输出：[0,0,0]
//解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
//- 值为 3 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 1 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 2 的节点没有堂兄弟，所以值修改为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目的范围是 [1, 10⁵] 。 
// 1 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 41 👎 0


package meiri.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CousinsInBinaryTreeIi {
    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTreeIi().new Solution();
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
        public TreeNode replaceValueInTree(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
            List<Integer> l = new ArrayList<Integer>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                int cnt = 0;
                while (size-- > 0) {
                    TreeNode cur = deque.poll();
                    cnt += cur.val;
                    if (cur.left != null) {
                        deque.add(cur.left);
                    }
                    if (cur.right != null) {
                        deque.add(cur.right);
                    }
                }
                l.add(cnt);
            }
            deque.add(root);
            root.val = 0;
            l.add(0);
            int depth = 1;
            while (!deque.isEmpty()) {
                int size = deque.size();
                while (size-- > 0) {
                    int t = 0;
                    TreeNode cur = deque.poll();
                    if (cur.left != null) {
                        deque.add(cur.left);
                        t += cur.left.val;
                    }
                    if (cur.right != null) {
                        deque.add(cur.right);
                        t += cur.right.val;
                    }
                    if (cur.left != null) {
                        cur.left.val = l.get(depth) - t;
                    }
                    if (cur.right != null) {
                        cur.right.val = l.get(depth) - t;
                    }

                }
                depth++;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}