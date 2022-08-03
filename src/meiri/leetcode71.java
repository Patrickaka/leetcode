package meiri;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution71 {
    public static String simplifyPath(String path) {
        String[] temp = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (String s : temp) {
            if (!"".equals(s) && !".".equals(s) && !"".equals(s)) {
                deque.addLast(s);
            }
            if ("".equals(s)) {
                if (deque.size() > 0) {
                    deque.pollLast();
                }
            }
        }
        while (deque.size() > 0) {
            sb.append("/").append(deque.remove());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "";
        String ans = simplifyPath(path);
        System.out.println(ans);
    }
}