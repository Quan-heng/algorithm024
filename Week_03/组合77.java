import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：回溯
 * 1->2,3,4
 * 2->3,4
 * 3->4
 */
public class 组合77 {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<k){
            return result;
        }
        if(k==0){
            return result;
        }
        Deque<Integer> list = new LinkedList<>();
        dfs(n,k,1,list,result,0);
        return result;
    }

    private static void dfs(int n, int k,int begin, Deque<Integer> list, List<List<Integer>> result, int depth) {
        if(depth==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = begin;i<=n;i++){
            list.add(i);
            dfs(n,k,i+1,list,result,depth+1);
            //reverse,回溯到上一步，重新组合
            list.removeLast();
        }
    }
}
