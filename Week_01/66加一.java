/*
思路：
1.末位不为0，加一直接返回
2.末位为9，置0，往前遍历加1
3.基于2，首位为0,数组拷贝，首位置1
 */
class Solution66 {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i--] = 0;
                continue;
            }
        }
        if (digits[0] == 0) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            return newArray;
        } else {
            return digits;
        }
    }
}