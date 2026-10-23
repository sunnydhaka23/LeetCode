class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int res = 0;
        while (a >= b) {
            long t = b, p = 1;
            while (a >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            a -= t;
            res += p;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }
}