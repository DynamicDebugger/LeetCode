class Solution {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            x = 1 / x;
            n = Integer.MAX_VALUE; // make n positive and reduce it by 1 later
            return x * myPow(x, n);
        }
        if(n < 0){
            x = 1 / x;
            n = n * -1;
        }        
        return solve(x ,n);
    }

    private double solve(double x, int n){
        if(n == 0){
            return 1;
        }

        // even - x * x, n/2
        // odd - x * (x * x, n/2)
        if(n % 2 == 0){
            return solve(x * x, n/2);
        }else{
            return x * solve(x * x, n/2);
        }
    }
}