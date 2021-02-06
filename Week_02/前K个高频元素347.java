import java.util.*;

public class 前K个高频元素347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
    public static int[] topKFrequent(int[] nums, int k){
        //思路，1. 记数，放入HashMap,
        //2. 将Map元素放入大顶堆（按value倒序），取出前K个
        int[] result = new int[k];
        if(nums==null||k==0) {
            return result;
        }
        PriorityQueue<Map.Entry<Integer,Integer>> countHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.entrySet().forEach(a->{
            countHeap.offer(a);
        });
        for(int i=0;i<k;i++){
            result[i] = countHeap.poll().getKey();
        }
        return result;
    }
}
