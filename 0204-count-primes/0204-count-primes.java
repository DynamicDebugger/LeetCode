class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;  // There are no primes less than 2.

        boolean[] prime = new boolean[n];  // Initialize array for numbers less than n.
        for (int i = 2; i < n; i++)
            prime[i] = true;

        // Start marking multiples of each prime number starting from 2
        for (int p = 2; p * p < n; p++) {
            if (prime[p]) {
                // Mark all multiples of p as false (non-prime)
                for (int i = p * p; i < n; i += p)
                    prime[i] = false;
            }
        }

        // Count all primes less than n
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) count++;
        }

        return count;
    }
}
