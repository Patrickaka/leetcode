import java.util.Arrays;

public class leetcode743 {

    static int N = 3, M = 3;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int idx = 0;

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }

    public static void main(String[] args) {
        Arrays.fill(he, -1);
        add(0, 1);
        add(0, 2);
        add(1, 2);
        for (int i = he[0]; i != -1; i = ne[i]) {
            int b = e[i]; // 存在由 a 指向 b 的边，权重为 c
            System.out.println(0 + " -> " + b);
        }
    }
}
