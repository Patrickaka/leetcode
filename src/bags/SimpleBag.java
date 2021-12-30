package bags;

import java.util.Scanner;

/**
 * @author Patrick
 */
public class SimpleBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        System.out.println(maxValue(n, c, v, w));
    }

    private static int maxValue(int n, int c, int[] v, int[] w) {
        int[] dp = new int[c + 1];
        for (int i = 0; i < c + 1; i++) {
            dp[i] = i > v[0] ? w[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= 0; j--) {
//                int x = dp[]
            }
        }
        return 0;
    }
}
