## 5.递归
* 递归模版
```
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```
* 递归的分支要满足(mutual exclusive, complete exclusive)
* leetcode-爬楼梯,用动态规划解决（一层循环)
* leetcode-括号生成,时间复杂度O(2^n)
```
  public static void generator(int left, int right, int n, String s, List<String> result) {
        //terminator
        if (left == n && right == n) {
            result.add(s);
        }
        //process
        //drill down
        if (left < n) {
            generator(left + 1, right, n, s + "(", result);
        }
        if (left>right) {
            generator(left, right + 1, n, s + ")",result);
        }   
        //reverse
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generator(0,0,n,"",result);
        return result;
    }
```

## 6.分治、回溯
特殊的递归，本质上就是找重复性，以及分解问题，最后组合每个子问题的结果。
* 分治步骤
    - terminator
    - process(split problem)
    - drill down(sub problems), merge(sub result)
    - reverse states
* 分治代码模版(典型的问题是[幂函数](https://github.com/Quan-heng/LeetCodeTraining/blob/master/src/main/java/Pow50.java))
```
def divide_conquer(problem, param1, param2, ...):
    # recursion terminator 终止条件
    if problem is None:
        print_result
        return
    # prepare data  处理当前层逻辑
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    # conquer subproblems  调用函数下探到下一层，解决更细节的子问题
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)

    # revert the current level states
    # 与泛型递归不同就是在drill down与revert state中间加了一步
    # ---> 就是把drill down得到的子结果要合并在一起，返回回去。
```

* 回溯
    > 可以理解为递归的一种问题，不断地在每一层去试，每一层有不同的办法，类似于一个一个去试，看这个方法是否可行。最典型的应用是八皇后问题、数独
     * 组合-leetcode77 https://github.com/Quan-heng/LeetCodeTraining/blob/master/src/main/java/%E7%BB%84%E5%90%8877.java