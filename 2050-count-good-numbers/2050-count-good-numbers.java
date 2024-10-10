class Solution {
    public int countGoodNumbers(long n) {
        long ev = (n + 1) / 2;
        long od = n / 2;
        long mod = 1000000007;
        long evenWays = powMod(5, ev, mod);  // 5^ev % mod
        long oddWays = powMod(4, od, mod);   // 4^od % mod

        // Calculate final result and return it
        return (int)((evenWays * oddWays) % mod);
    }
    long powMod(long x, long y, long mod) {
        long result = 1;
        x = x % mod; // Take x modulo to prevent overflow in the loop
        while (y > 0) {
            if ((y & 1) == 1) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod; // Square x and reduce mod
            y >>= 1;           // Divide y by 2
        }
        return result;
    }    
}