// naive solution recursive approach

class Solution{
    public int maximumPoints(int points[][],int n){
        return func(n-1,3,points);
    }
    public int func(int day,int last,int[][] point){
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi=Math.max(point[0][i],maxi);
                }
            }
            return maxi;
        }
        
        int maxi=0;
        
        for(int i=0;i<3;i++){
            if(i!=last){
                int points = point[day][i] +func(day-1,i,point);
                maxi =Math.max(points,maxi);
            }
        }
        return maxi;
    }
}

// Memoization DP
//Time Complexity: O(N*4*3)
//Reason: There are N*4 states and for every state, we are running a for loop iterating three times.

//Space Complexity: O(N) + O(N*4)
//Reason: We are using a recursion stack space(O(N)) and a 2D array (again O(N*4)). Therefore total space complexity will be O(N) + O(N) ≈ O(N)



class Solution{
    public int maximumPoints(int points[][],int n){
        int[][] dp= new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);
            
        return func(n-1,3,points,dp);
    }
    public int func(int day,int last,int[][] point,int[][] dp) {
        
        if(dp[day][last]!=-1) return dp[day][last];
        
        if(day==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi=Math.max(point[0][i],maxi);
                }
            }
            return dp[day][last] =maxi;
        }
        
        int maxi=0;
        
        for(int i=0;i<3;i++){
            if(i!=last){
                int points = point[day][i] +func(day-1,i,point,dp);
                maxi =Math.max(points,maxi);
            }
        }
        return dp[day][last] = maxi;
    }
}


//Tabulation DP

class Solution{
    public int maximumPoints(int points[][],int n){
        //code here
        int[][] dp =new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;
                
                for(int task=0;task<=2;task++){
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
}
