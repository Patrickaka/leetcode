package zhousai.leetcode6158;

class Solution {

    public static void main(String[] args) {
        System.out.println((char) ('a' + (25 + 26 - 27 % 26)));
    }

    /**
     * 差分
     * 利用差分数组统计每个位数需要移动的次数
     *
     * @param s      小写英文字母组成的字符串
     * @param shifts shifts[i] = [start, end, direction]
     * @return 对 s 进行所有移位操作以后得到的最终字符串
     */
    public String shiftingLetters(String s, int[][] shifts) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] diff = new int[n + 1];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diff[shift[0]] += 1;
                diff[shift[1] + 1] -= 1;
            } else {
                diff[shift[0]] -= 1;
                diff[shift[1] + 1] -= -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            char c = cs[i];
            int t = c - 'a';
            cs[i] = (char) ('a' + ((t + 26 * 2000 + sum) % 26));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(c);
        }
        return sb.toString();
    }

}