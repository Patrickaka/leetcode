import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution851 {

    int N = 500, M = 500 * 499 / 2;

    int[] he = new int[N], e = new int[M], ne = new int[M], inDegree = new int[N];
    int idx = 0;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        inDegree[b]++;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Arrays.fill(he, -1);
        int length = quiet.length;
        int[] ans = new int[length];
        for (int[] nums : richer) {
            add(nums[0], nums[1]);
        }

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            if (inDegree[i] == 0) {
                d.addLast(i);
            }
            ans[i] = i;
        }

        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int temp = e[i];
                if (quiet[ans[poll]] < quiet[ans[temp]]) {
                    ans[temp] = ans[poll];
                }
                if (--inDegree[temp] == 0) {
                    d.addLast(temp);
                }
            }
        }

        return ans;
    }
}