import java.util.ArrayDeque;
import java.util.Deque;

/**
 * JAVA获得一个数组的指定长度的排列组合。<br>
 */
public class demo {

    // 存储结果的堆栈

    Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        demo t = new demo();
        int[] arr = {1, 2, 3, 4, 5, 6 ,7 ,8, 9, 10 ,11};
        // 循环获得每个长度的排列组合
        t.getSequence(arr, 0, 11);
    }

    /**
     * 获得指定数组从指定开始的指定数量的数据组合<br>
     *
     * @param arr   指定的数组
     * @param begin 开始位置
     * @param num   获得的数量
     */
    public void getSequence(int[] arr, int begin, int num) {
        if (num == 0) {
            int j = deque.size();
            for (int i = 1; i <= j; i++) {
                int temp = deque.pollFirst();
                System.out.print("(" + i + "," + temp + ")");
                deque.addLast(temp);
            }
            System.out.println("");
        } else {
            // 循环每个可用的元素
            for (int i = begin; i < arr.length; i++) {
                // 当前位置数据放入结果堆栈
                deque.push(arr[i]);
                // 将当前数据与起数据交换
                swap(arr, begin, i);
                // 从下一个位置查找其余的组合
                getSequence(arr, begin + 1, num - 1);
                // 交换回来
                swap(arr, begin, i);
                // 去除当前数据
                deque.pop();
            }
        }
    }

    /**
     * 交换2个数组的元素
     *
     * @param arr  数组
     * @param from 位置1
     * @param to   位置2
     */
    public static void swap(int[] arr, int from, int to) {
        if (from == to) {
            return;
        }
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}