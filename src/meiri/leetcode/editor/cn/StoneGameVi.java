//Alice 和 Bob 轮流玩一个游戏，Alice 先手。 
//
// 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方
//都知道对方的评判标准。 
//
// 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 
//Alice 和 Bob 认为第 i 个石子的价值。 
//
// 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。 
//
// 请你推断游戏的结果，用如下的方式表示： 
//
// 
// 如果 Alice 赢，返回 1 。 
// 如果 Bob 赢，返回 -1 。 
// 如果游戏平局，返回 0 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：aliceValues = [1,3], bobValues = [2,1]
//输出：1
//解释：
//如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
//Bob 只能选择石子 0 ，得到 2 分。
//Alice 获胜。
// 
//
// 示例 2： 
//
// 
//输入：aliceValues = [1,2], bobValues = [3,1]
//输出：0
//解释：
//Alice 拿石子 0 ， Bob 拿石子 1 ，他们得分都为 1 分。
//打平。
// 
//
// 示例 3： 
//
// 
//输入：aliceValues = [2,4,3], bobValues = [1,6,7]
//输出：-1
//解释：
//不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
//比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
//Bob 会获胜。
// 
//
// 
//
// 提示： 
//
// 
// n == aliceValues.length == bobValues.length 
// 1 <= n <= 10⁵ 
// 1 <= aliceValues[i], bobValues[i] <= 100 
// 
//
// Related Topics 贪心 数组 数学 博弈 排序 堆（优先队列） 👍 72 👎 0

package meiri.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class StoneGameVi {
    public static void main(String[] args) {
        Solution solution = new StoneGameVi().new Solution();
        int[] alice = {2, 4, 3};
        int[] bob = {1, 6, 7};
        System.out.println(solution.stoneGameVI(alice, bob));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Stone {
        int index;
        int value;

        public Stone(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    class Solution {
        public int stoneGameVI(int[] aliceValues, int[] bobValues) {
            int n = aliceValues.length;
            int alicesum = 0, bobsum = 0;
            PriorityQueue<Stone> alicep = new PriorityQueue<>((a, b) -> b.value - a.value);
            PriorityQueue<Stone> bobp = new PriorityQueue<>((a, b) -> b.value - a.value);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                alicep.add(new Stone(i, aliceValues[i]));
                bobp.add(new Stone(i, bobValues[i]));
            }
            int turn = 1;
            while (!alicep.isEmpty() || !bobp.isEmpty()) {
                if (bobp.isEmpty()) {
                    alicesum += alicep.poll().value;
                    break;
                }
                if (alicep.isEmpty()) {
                    bobsum += bobp.poll().value;
                    break;
                }
                if (turn == 1) {
                    alicesum = getAlicesum(aliceValues, bobValues, alicep, bobp, alicesum, set);
                } else {
                    bobsum = getAlicesum(bobValues, aliceValues, bobp, alicep, bobsum, set);
                }
                turn *= -1;
            }
            return Integer.compare(alicesum, bobsum);
        }

        private int getAlicesum(int[] aliceValues, int[] bobValues, PriorityQueue<Stone> alicep, PriorityQueue<Stone> bobp, int alicesum, Set<Integer> set) {
            Stone alice = alicep.peek();
            Stone bob = bobp.peek();
            if (alice.index == bob.index) {
                alicep.poll();
                bobp.poll();
                alicesum += alice.value;
                set.add(alice.index);
            } else {
                int pa = aliceValues[alice.index] + bobValues[alice.index];
                int pb = aliceValues[bob.index] + bobValues[bob.index];
                if (pa >= pb) {
                    alicep.poll();
                    alicesum += alice.value;
                    set.add(alice.index);
                } else {
                    bobp.poll();
                    alicesum += aliceValues[bob.index];
                    set.add(bob.index);
                }
            }
            while (!alicep.isEmpty() && set.contains(alicep.peek().index)) {
                alicep.poll();
            }
            while (!bobp.isEmpty() && set.contains(bobp.peek().index)) {
                bobp.poll();
            }
            return alicesum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}