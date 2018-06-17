class Solution {
    public int longestValidParentheses(String s) {
        // Solution 1 -- Dynamic Programming
        char[] str = s.toCharArray();
        int len = str.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++){
            if (str[i] == ')'){
                // str[i - 1] == '('
                if ( str[i - 1] == '(' )    dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                // str[i - 1] == ')'
                else{
                    if ( i - 1 - dp[i - 1] >= 0 &&str[i - 1 - dp[i - 1] ] == '(' )   dp[i] = i - dp[i-1] - 2 >= 0 ?  dp[i-1] + 2 + dp[i - dp[i-1] - 2] :  dp[i-1] + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        // Solution 2 -- Stack
        
    }
}
