学习笔记
## 第12课  动态规划的实现及关键点 
> 如果没有最优子结构，说明所有的子问题都要计算一遍，同时把最后的结果合并在一起。所以传统意义上就称之为分治。能否非要叫做动态规划？其实也可以，你可以理解为每次的最优解就是当前解即可，没有比较和淘汰的一个过程。
* 查看各种数据结构动画，https://visualgo.net/zh
* 关键点I
  * 动态递推，最好自底向上
  * 动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）
  * 共性：找到重复子问题
  * 差异性：最优子结构、中途可以淘汰次优解
* 关键点II
  * 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
  * 储存中间状态：opt[i]
  * 递推公式(美其名曰:状态转移方程或者DP方程)
    * Fib:opt[i]=opt[i-1]+opt[i-2]
    * 二维路径: opt[i,j]=opt[i+1][j]+opt[i][j+1]
    
* DP步骤
  * 找重复性（分治）
  * 定义状态数组一维或是二维
  * 找到DP方程
     
     


