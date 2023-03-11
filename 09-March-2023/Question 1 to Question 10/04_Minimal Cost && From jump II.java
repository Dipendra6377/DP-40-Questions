

class Solution{
    public int minimizeCost(int arr[],int n,int k){
        //code here
        int[] dp=new int[n+1];
        dp[0]=0;
        
        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int st = dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    minSteps = Math.min(minSteps,st);
                }
                dp[i]=minSteps;
            }
        }
        return dp[n-1];
    }
}
