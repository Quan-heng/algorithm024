/*
思路：空间换时间，用HashMap保存遍历过的值与索引,找target-num[i]是否存在于HashMap中
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];

        if(nums==null||nums.length==1){
            return result;
        }

        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}