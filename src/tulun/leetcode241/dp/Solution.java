package tulun.leetcode241.dp;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        char[] array = expression.toCharArray();
        int num = 0;
        for (char c : array) {
            if (isOpreation(c)) {
                numList.add(num);
                num = 0;
                opList.add(c);
                continue;
            }
            num = num * 10 + c - '0';
        }
        numList.add(num);
        int N = numList.size();
        //一个数字
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(numList.get(i));
            dp[i][i] = result;
        }
        for (int n = 2; n <= N; n++) {
            for (int i = 0; i < N; i++) {
                int j = i + n - 1;
                if (j >= N) {
                    break;
                }
                ArrayList<Integer> result = new ArrayList<>();
                for (int s = i; s < j; s++) {
                    ArrayList<Integer> result1 = dp[i][s];
                    ArrayList<Integer> result2 = dp[s + 1][j];
                    for (int x = 0; x < result1.size(); x++) {
                        for (int y = 0; y < result2.size(); y++) {
                            char op = opList.get(s);
                            result.add(caculate(result1.get(x), op, result2.get(y)));
                        }
                    }
                }
                dp[i][j] = result;
            }
        }
        return dp[0][N - 1];
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }

    private boolean isOpreation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}