import java.util.*;

public class relative_sort_array {
    /**
     * 解题思路：
     * 自定义排序
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Collections.sort(list, (x, y) -> {
                    if (map.containsKey(x) || map.containsKey(y)) {
                        return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
                    } else {
                        return x - y;
                    }
                }
        );
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

}
