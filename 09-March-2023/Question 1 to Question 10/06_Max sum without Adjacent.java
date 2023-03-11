//Memoization

class Solution {
    int func(int[] arr,int[] dp,int ind){
        if(ind==0){
            return arr[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        int pick =arr[ind] + func(arr,dp,ind-2);
        
        int notpick = 0+ func(arr,dp,ind-1);
        
        return dp[ind] =Math.max(pick,notpick);
    }
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
         
        return func(arr,dp,n-1);
        
    }
}


//Tabulation No extra Stack space required

class Solution {
    
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp=new int[n+1];

         
        dp[0]=arr[0];
        int sum=0;
        for(int i=1;i<n;i++){
            int pick= arr[i]; if(i>1){pick += dp[i-2];
                
            }
            int notpick =0+dp[i-1];
            
            dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}
