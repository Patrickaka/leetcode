package moni.leetcode558;

class Solution {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            } else if (quadTree2.val) {
                return quadTree2;
            } else {
                return quadTree1;
            }
        }
        Node ans = new Node();
        ans.topLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.topLeft);
        ans.topRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight, quadTree2.isLeaf ? quadTree2 : quadTree2.topRight);
        ans.bottomLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomLeft);
        ans.bottomRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomRight);
        if (ans.topLeft.isLeaf && ans.topRight.isLeaf && ans.bottomLeft.isLeaf && ans.bottomRight.isLeaf) {
            if (ans.topLeft.val == ans.topRight.val && ans.topLeft.val == ans.bottomLeft.val && ans.bottomLeft.val == ans.bottomRight.val) {
                ans.isLeaf = true;
                ans.val = ans.topLeft.val;
                ans.topLeft = ans.topRight = ans.bottomLeft = ans.bottomRight = null;
            }
        }
        return ans;
    }
}