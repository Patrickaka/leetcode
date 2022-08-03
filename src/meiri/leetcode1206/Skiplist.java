package meiri.leetcode1206;

import java.util.Random;

class Skiplist {

    static int level = 10;
    Random random = new Random();
    Node he = new Node(-1);

    public Skiplist() {

    }

    void find(int t, Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.ne[i] != null && cur.ne[i].val < t) {
                cur = cur.ne[i];
            }
            ns[i] = cur;
        }
    }

    public boolean search(int target) {
        Node[] ns = new Node[level];
        find(target, ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == target;
    }

    public void add(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = new Node(num);
        for (int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if (random.nextInt(2) == 0) {
                break;
            }
        }
    }

    public boolean erase(int num) {
        Node[] ns = new Node[level];
        find(num, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != num) {
            return false;
        }
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) {
            ns[i].ne[i] = ns[i].ne[i].ne[i];
        }
        return true;
    }

    static class Node {
        int val;
        Node[] ne = new Node[level];

        public Node(int val) {
            this.val = val;
        }
    }
}