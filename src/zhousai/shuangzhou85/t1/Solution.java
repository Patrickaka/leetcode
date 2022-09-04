package zhousai.shuangzhou85.t1;

class Solution {

    /**
     * 滑动窗口
     * 等价于求在block内找出长度为k的子区间，其中W最少的区间
     *
     * @param blocks blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
     * @param k      想要连续黑色块的数目
     * @return 至少出现 一次 连续 k 个黑色块的 最少 操作次数
     */
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int ans = n + 1;
        for (int i = 0; i + k <= n; i++) {
            int min = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    min++;
                }
            }
            ans = Math.min(ans, min);
        }
        return ans;
    }

}