package review.zhousai.leetcode6150;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestNumber("IIIDIDDD"));
    }

    public String smallestNumber(String pattern) {
        char[] patterns = pattern.toCharArray();
        int idx = 1, ld = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < patterns.length; i++) {
            if (patterns[i] == 'I') {
                if (ld != 0) {
                    for (int j = ld; j > 0; j--) {
                        sb.append(idx + j);
                    }
                }
                sb.append(idx);
                idx += ld;
                idx++;
                ld = 0;
            } else if (patterns[i] == 'D') {
                ld++;
            }
        }
        if (ld != 0) {
            for (int j = ld; j >= 0; j--) {
                sb.append(idx + j);
            }
        } else {
            sb.append(idx);
        }

        return sb.toString();
    }
}