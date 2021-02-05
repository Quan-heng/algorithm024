class Solution26 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                continue;
            }else{
                index++;
                if(index!=i){
                    nums[index] = nums[i];
                }
            }
        }
        return index+1;
    }
}