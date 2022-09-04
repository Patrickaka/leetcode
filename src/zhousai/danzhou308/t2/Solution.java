package zhousai.danzhou308.t2;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeStars("leet**cod*e"));
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sb.delete(sb.length() - 1, sb.length());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}