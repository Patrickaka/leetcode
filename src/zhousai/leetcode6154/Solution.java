package zhousai.leetcode6154;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        node1.left = node5;
        node1.right = node3;
        node5.right = node4;
        node3.left = node10;
        node3.right = node6;
        node4.left = node9;
        node4.right = node2;
        System.out.println(solution.amountOfTime(node1, 3));
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    int M = (int) 1e5 + 1, N = M * 2, idx = 0;

    public int amountOfTime(TreeNode root, int start) {
        Arrays.fill(he, -1);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node.left != null) {
                add(node.val, node.left.val);
                add(node.left.val, node.val);
                deque.add(node.left);
            }
            if (node.right != null) {
                add(node.val, node.right.val);
                add(node.right.val, node.val);
                deque.add(node.right);
            }
        }
        Set<Integer> set = new HashSet<>();
        Deque<Integer> d = new ArrayDeque<>();
        set.add(start);
        d.add(start);
        int ans = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            System.out.println(size);
            ans++;
            while (size-- > 0) {
                int node = d.pollFirst();
                for (int i = he[node]; i != -1; i = ne[i]) {
                    if (!set.contains(e[i])) {
                        d.add(e[i]);
                        set.add(e[i]);
                    }
                }
            }
        }
        return ans - 1;
    }

    int[] he = new int[M], ne = new int[N], e = new int[N];

    public static class TreeNode {
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


}