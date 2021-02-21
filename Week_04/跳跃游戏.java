/**
 * 思路：贪心算法，从后往前
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0};
        System.out.println(canJump(nums));
    }

    /**
     * 解法1：贪心解法，从后往前
     * @param nums
     * @return
     */
    public static boolean canJumpTanXin(int[] nums){
        if(nums==null) return false;
        int reachable = nums.length-1;
        for (int i = nums.length - 2; i >= 0; i--) {//倒数第一个元素不需要遍历
            if(nums[i]+i>=reachable){//重点理解这里
                reachable = i;
            }
        }
        return reachable==0;
    }
    /**解法2：
     * 遍历将各个元素能往后跳的空格设为true,看最后一格是否为true,时间复杂度O(n2)
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return true;
        boolean[] flag = new boolean[nums.length];
        int firstStep = nums[0];
        for(int i=0;i<nums.length&&i<=firstStep;i++){
            flag[i]= true;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if(!flag[i]) continue;
            int temp = nums[i];
            if (temp == 0) continue;
            for (int j = i; j < nums.length && j <= i + temp; j++) {
                flag[j] = true;
            }
        }
        return flag[nums.length - 1];
    }
}
