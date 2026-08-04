class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] vis=new boolean[row][col];
        int noi=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    noi++;
                    dfs(vis,grid,i,j);
                }
            }
        }
        return noi;
        
    }
    public void dfs(boolean[][] vis,char[][] grid,int i,int j){
        int row=grid.length;int col=grid[0].length;
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]=='0' || vis[i][j]){
            return ;
        }
        vis[i][j]=true;
        dfs(vis,grid,i+1,j);
        dfs(vis,grid,i,j+1);
        dfs(vis,grid,i-1,j);
        dfs(vis,grid,i,j-1);
    }
}