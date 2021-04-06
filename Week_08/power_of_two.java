public class power_of_two {
    public boolean isPowerOfTwo(int n) {
        long num = n;
        return num != 0 && (num & (num - 1)) == 0;
    }
}
