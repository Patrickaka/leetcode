import java.util.*;

class Solution802 {
    int N = 10000, M = 40000;

    int[] he = new int[N], e = new int[M], ne = new int[M], inDegree = new int[N];
    int idx = 0;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        inDegree[b]++;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        int length = graph.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                add(graph[i][j], i);
            }
        }
        //拓扑排序
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            if (inDegree[i] == 0) {
                d.addLast(i);
            }
        }
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--inDegree[j] == 0) {
                    d.addLast(j);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
