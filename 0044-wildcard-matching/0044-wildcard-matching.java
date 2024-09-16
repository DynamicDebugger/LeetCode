class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        Boolean dp[][] = new Boolean[m + 1][n + 1];
        for (Boolean[] row : dp)
            Arrays.fill(row, null);

        return matches(m - 1, n - 1, s, p, dp);
    }

    private boolean matches(int i, int j, String s, String p, Boolean[][] dp){

        //base case
        if(i < 0 && j < 0)  return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0) return isHelper(j, p);
        

        if(dp[i][j] != null) return dp[i][j];


        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = matches(i - 1, j - 1, s, p, dp);//matches
        }else{
            if(p.charAt(j) == '*'){
                return dp[i][j] = matches(i , j - 1, s, p, dp) || matches(i - 1, j, s, p, dp);
            }            
            else{
                return false;
            }
        }

    }

    private boolean isHelper(int n, String s){
        for(int i = 0 ; i <= n ;i++){
            if(s.charAt(i) != '*')  return false;
        }

        return true;
    }
}