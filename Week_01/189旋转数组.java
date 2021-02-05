class Solution189 {
    public void rotate(int[] nums, int k) {
        if(nums==null){
            return;
        }

        int[] tempArr = new int[nums.length];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            step = i+k;
            if(step>=nums.length){
                step = (step- nums.length)% nums.length;
            }
            tempArr[step] = nums[i];
        }
        for (int i = 0; i < tempArr.length; i++) {
            nums[i] = tempArr[i];
        }
    }
}