//解题思路：
//1.第一次遍历将非0元素前移，
//2.第二次遍历0填充剩下位置。
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for(int k = j;k<nums.length;k++){
            nums[k]=0;
        }
    }
}