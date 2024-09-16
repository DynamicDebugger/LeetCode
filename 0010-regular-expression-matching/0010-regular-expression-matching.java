class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        Boolean dp[][] = new Boolean[m + 1][n + 1];
        for (Boolean[] row : dp)
            Arrays.fill(row, null);

        return matches(m - 1, n - 1, s, p, dp);
    }

    private boolean matches(int i, int j, String s, String p, Boolean[][] dp) {

        // Base cases
        if (i < 0 && j < 0) return true; // Both strings are completely matched
        if (j < 0) return false;         // Pattern exhausted but string not yet matched
        if (i < 0) return isHelper(j, p); // String exhausted, check if the remaining pattern can match an empty string

        if (dp[i][j] != null) return dp[i][j]; // Use memoization to save previous results

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // Direct match or '.' match
            return dp[i][j] = matches(i - 1, j - 1, s, p, dp);
        } else {
            if (p.charAt(j) == '*') {
                // Check if the '*' can match 0 or more of the preceding element
                if (j > 0 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                    // If the preceding element matches, we can:
                    // 1. Consider '*' matching one or more characters: matches(i - 1, j, s, p, dp)
                    // 2. Skip the '*' and preceding element: matches(i, j - 2, s, p, dp)
                    return dp[i][j] = matches(i - 1, j, s, p, dp) || matches(i, j - 2, s, p, dp);
                } else {
                    // If the preceding element doesn't match, '*' can only skip the preceding element
                    return dp[i][j] = matches(i, j - 2, s, p, dp);
                }
            } else {
                // No match
                return dp[i][j] = false;
            }
        }
    }

    private boolean isHelper(int j, String p) {
        // Handle cases where pattern is something like "a*b*" which should match an empty string
        for (int i = 0; i <= j; i += 2) {
            // We need to ensure the pattern is composed of valid "*" pairs
            if (p.charAt(i) != '*' && (i + 1 > j || p.charAt(i + 1) != '*')) return false;
        }
        return true;
    }
}
