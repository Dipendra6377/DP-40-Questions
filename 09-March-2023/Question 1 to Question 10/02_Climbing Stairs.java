class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return function(n-1,dp)+function(n-2,dp);
    }
    public int function(int n,int[] dp){
        if(n<0) return 0;
        if(n==1 || n==0){
            dp[n]=1;
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=function(n-1,dp)+function(n-2,dp);
        return dp[n];

    }
}
