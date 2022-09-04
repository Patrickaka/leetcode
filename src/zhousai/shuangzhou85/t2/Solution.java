package zhousai.shuangzhou85.t2;

class Solution {

    /**
     * 简单模拟==
     *
     * @param s 二进制字符串
     * @return 完成字符串没有 "01" 存在所需要的秒数
     */
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            ans++;
        }
        return ans;
    }
}