import java.util.PriorityQueue;

public class 丑数264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        //思路：PriorityQueue,小顶堆
        PriorityQueue<Long> heap = new PriorityQueue<>();
        long result = 1; //用int会越界
        heap.offer(result);
        for (int i = 0; i < n; i++) {
            result = heap.poll();
            while (!heap.isEmpty() && result == heap.peek()) { //记得去重
                heap.poll();
            }
            heap.offer(result * 2);
            heap.offer(result * 3);
            heap.offer(result * 5);
        }
        return  (int)result;
    }
}
