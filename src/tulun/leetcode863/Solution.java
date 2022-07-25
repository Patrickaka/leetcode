package tulun.leetcode863;

import java.util.*;

public class Solution {

    int[] e = new int[M], ne = new int[M], he = new int[N];
    static int N = 510, M = N * 4;
    int idx;
    boolean[] vis = new boolean[N];

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(he, -1);
        dfs(root);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(target.val);
        vis[target.val] = true;
        while (!deque.isEmpty() && k > 0) {
            k--;
            int size = deque.size();
            for (int num = 0; num < size; num++) {
                int poll = deque.pollFirst();
                for (int i = he[poll]; i != -1; i = ne[i]) {
                    if (vis[e[i]]) {
                        continue;
                    }
                    vis[e[i]] = true;
                    deque.addLast(e[i]);
                }
            }
        }
        return new ArrayList<>(deque);
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}