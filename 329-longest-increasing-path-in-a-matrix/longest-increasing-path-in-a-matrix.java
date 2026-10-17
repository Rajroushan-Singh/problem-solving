class Solution {
    int[][] dp;
    // int ans;
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        int ans=0;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(dfs(i,j,matrix),ans);
            }
        }
        return ans;
    }
    public int dfs(int i,int j,int[][] matrix){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        m=matrix.length;
        n=matrix[0].length;
        dp[i][j]=1;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        int c=0;
        if(dp[i][j]!=0)
        for(int[] d:dirs){
            int ni=i+d[0];
            int nj=j+d[1];

            if( ni>=0 && ni<m && nj>=0 && nj<n && matrix[i][j]<matrix[ni][nj] ){
                dp[i][j] = Math.max(dp[i][j],(dfs(ni,nj,matrix)+1));
            }

        }
        return dp[i][j];
    }
}