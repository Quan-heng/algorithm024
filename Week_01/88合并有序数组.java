/*解题思路，
从末尾开始填充数组，将num2没有比较完的元素copy到nums1的头部
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length1 = m-1;
        int length2 = n-1;
        int tail = m+n-1;
        while(length2>=0&&length1>=0){
            int max = nums1[length1]>nums2[length2]?nums1[length1--]:nums2[length2--];
            nums1[tail--]  = max;
        }
        if(length2>=0){
            System.arraycopy(nums2,0,nums1,0,length2+1);
        }
        System.out.println(Arrays.toString(nums1));
    }
}