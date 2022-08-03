package meiri.leetcode427;

class Solution {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    int[][] grid;

    public Node construct(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        return dfs(0, 0, n - 1, n - 1);
    }

    Node dfs(int a, int b, int c, int d) {
        boolean flag = true;
        int t = grid[a][b];
        for (int i = a; i <= c && flag; i++) {
            for (int j = b; j <= d && flag; j++) {
                if (grid[i][j] != t) {
                    flag = false;
                }
            }
        }
        if (flag) {
            return new Node(t == 1, true);
        } else {
            Node node = new Node(t == 1, false);
            int dx = c - a + 1, dy = d - b + 1;
            node.topLeft = dfs(a, b, a + dx / 2 - 1, b + dy / 2 - 1);
            node.topRight = dfs(a, b + dy / 2, a + dx / 2, d);
            node.bottomLeft = dfs(a + dx / 2, b, c, b + dy / 2);
            node.bottomRight = dfs(a + dx / 2, b + dy / 2, c, d);
            return node;
        }
    }
}

