package zidianshu.leetcode648.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    TreeNode root = new TreeNode();

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ds = new ArrayList<>();
        ds.add("cat");
        ds.add("rat");
        ds.add("bat");
        String s = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(ds, s));
    }

    void add(String s) {
        TreeNode t = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (t.tr[u] == null) {
                t.tr[u] = new TreeNode();
            }
            t = t.tr[u];
        }
        t.end = true;
    }

    String query(String s) {
        TreeNode t = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (t.tr[u] != null) {
                if (t.tr[u].end) {
                    return s.substring(0, i + 1);
                }
                t = t.tr[u];
            } else {
                return s;
            }
        }
        return s;
    }

    public String replaceWords(List<String> ds, String s) {
        for (String str : ds) {
            add(str);
        }
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            sb.append(query(str)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    static class TreeNode {
        TreeNode[] tr = new TreeNode[26];
        boolean end;
    }
}
