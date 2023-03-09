class Solution {
    static long mod=1000000007;
    static long fib(int n,long[] dp){
        if(n==0 || n==1) return n;
        
        if(dp[n]!=-1) return dp[n];
        return dp[n]=(fib(n-1,dp) + fib(n-2,dp))%mod;
    }
    static long topDown(int n) {
        // code here
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        return fib(n,dp);
    }

    static long bottomUp(int n) {
        long[] dp=new long[n+1];
        
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        return dp[n];
    }
}
