/**
 *思路：二分查找
 * 将二维数组转换为一维数组，再进行二分查找
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //二维转一维
        int[] array = new int[m*n];
        int index = 0;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                array[index++] = matrix[i][j];
            }
        }
        //二分查找模板
        int left = 0;
        int right = m*n-1;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(array[mid]==target){
                return true;
            }else if(array[mid]>target){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
