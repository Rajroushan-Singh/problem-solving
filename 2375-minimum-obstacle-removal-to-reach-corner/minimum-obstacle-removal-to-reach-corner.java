class Solution {
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dis=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        Deque<int[]> dq=new ArrayDeque<>();
        dis[0][0]=0;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        dq.offerFirst(new int[]{0,0});
        int ans=0;
        while(!dq.isEmpty()){
            int[] node=dq.poll();
            int x=node[0];
            int y=node[1];
            if(x==m-1 && y==n-1){return dis[x][y];}
            for(int d=0;d<4;d++){
                int nx=x+dir[d][0];
                int ny=y+dir[d][1];
                if(nx<0 || ny<0 || nx>=m || ny>=n){continue;}
                if(dis[nx][ny]>dis[x][y]+grid[x][y]){
                    dis[nx][ny]=dis[x][y]+grid[x][y];
                    if(grid[nx][ny]==0){
                        dq.offerFirst(new int[]{nx,ny});
                    }else{
                        dq.offerLast(new int[]{nx,ny});
                        
                    }
                }
            }
        }
        return ans;
    }
}