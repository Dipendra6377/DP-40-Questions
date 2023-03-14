class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp =new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else{
                int path1=0 ;
                int path2=0;
                if(i>0){
                    path1 += dp[i-1][j];
                } 
                if(j>0){
                    path2+= dp[i][j-1];
                }
                dp[i][j]=path1+path2;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
