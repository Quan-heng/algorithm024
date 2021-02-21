/**
 * 解题思路：二分查找,num[mid],target和nums[0]比较看是否在同一侧，如果不是先调整mid位置。
 * mid和target在同侧后再进行二分查找。
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0] && target < nums[0]) {//mid在左侧，target在右侧,mid右移
                left = mid + 1;
            } else if (nums[mid] < nums[0] && target >= nums[0]) {//mid在右侧，target在左则，mid左移
                right = mid - 1;
            } else if (nums[mid] < nums[left] && target < nums[left] //mid,target和在同一侧
                    || nums[mid] >= nums[left] && target >= nums[left]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }
}

