学习笔记
## 二分查找的前提
* 目标函数单调递增或递减
* 存在上下界
* 通够通过索引访问
* 二分查找模版
```
public int binarySearch(int[] array, int target) {    
    int left = 0, right = array.length - 1, mid;    
    while (left <= right) {        
        mid = (right - left) / 2 + left;        
        if (array[mid] == target) {            
            return mid;        
        } else if (array[mid] > target) {            
            right = mid - 1;        
        } else {            
            left = mid + 1;        
        }    
    }    
    return -1;
}
```
* 求a平方根可以用牛顿迭代法,x0的初始值为a,不断计算，一直至x0<=a。
 公式：```x0 = (x0+a/x0)/2```
  
