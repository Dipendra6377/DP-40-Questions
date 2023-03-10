// using memization Space complexity O(N) for stack space and O(N) for dp extra array space
class Solution{
    public int func(int[] arr,int ind,int[] dp){
        if(ind==0){
            return 0;
        }
        
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        int left = func(arr,ind-1,dp) +Math.abs(arr[ind]-arr[ind-1]);
        int right =Integer.MAX_VALUE;
        if(ind>1){
            right=func(arr,ind-2,dp) +Math.abs(arr[ind]-arr[ind-2]);
        }
        return dp[ind]=Math.min(left,right);
    }
    public int minimumEnergy(int arr[],int n){
        //code here
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(arr,n-1,dp);
    }
}




// using tabulation no Extra stack space

class Solution{
    public int minimumEnergy(int arr[],int n){
        //code here
        int[] dp =new int[n+1];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int f = dp[i-1]+ Math.abs(arr[i]-arr[i-1]);
            int s = Integer.MAX_VALUE;
            if(i>1){
                s=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(s,f);
        }
        return dp[n-1];
    }
}


// Space optimisd No extra space needed

class Solution{
    public int minimumEnergy(int arr[],int n){
        //code here
        int prev=0;
        int prev0=0;
        for(int i=1;i<n;i++){
            int f = prev+ Math.abs(arr[i]-arr[i-1]);
            int s = Integer.MAX_VALUE;
            if(i>1){
                s=prev0+Math.abs(arr[i]-arr[i-2]);
            }
            int curr=Math.min(s,f);
            prev0=prev;
            prev=curr;
        }
        return prev;
    }
}
