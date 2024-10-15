class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, n = cardPoints.length;
        
        for(int i = 0 ; i < k ; i++) sum += cardPoints[i];
        if(k == n) return sum;

        int max = sum;
        int i = 0;
        while(i < k){
            sum = sum - cardPoints[k - 1 - i];
            sum = sum + cardPoints[n - 1 - i];
            max = Math.max(sum, max);
            i++;
        }
        return max;
    }
}