class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] vis=new boolean[row][col];
        int maxarea=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    int area=dfs(vis,grid,i,j);
                    maxarea=Math.max(maxarea,area);
                }
            }
        }
        return maxarea;
        
    }
    public int dfs(boolean[][] vis,int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j] || grid[i][j]==0){
            return 0;
        }
        int area=1;
        vis[i][j]=true;
        area+=dfs(vis,grid,i+1,j);
        area+=dfs(vis,grid,i,j+1);
        area+=dfs(vis,grid,i-1,j);        
        area+=dfs(vis,grid,i,j-1);
        return area;        
    }
}