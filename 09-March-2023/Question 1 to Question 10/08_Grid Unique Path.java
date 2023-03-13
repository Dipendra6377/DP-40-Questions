//Memoization
//Time Complexity: O(M*N)
//Reason: At max, there will be M*N calls of recursion.

//Space Complexity: O((N-1)+(M-1)) + O(M*N)
//Reason: We are using a recursion stack space:O((N-1)+(M-1)), here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[m][n];
        for(int[] row :dp){
            Arrays.fill(row,-1);
        }

        return func(m-1,n-1,dp);
    }

    public int func(int row,int col,int[][] dp){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int path1 = func(row-1,col,dp);
        int path2 = func(row,col-1,dp);

        return dp[row][col]=path1+path2;
    }
}


//Tabulation

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){ dp[0][0]=1;
                continue;
                }
                int path1=0;
                int path2=0;
                if(i>0)
                { path1  = dp[i-1][j];}
                if(j>0) {path2 =dp[i][j-1];}

                dp[i][j]=path1+path2;
            }
        }

        return dp[m-1][n-1];
    }
}
