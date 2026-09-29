class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int dis=0;
        boolean[][][] vis=new boolean[m][n][k+1];
        vis[0][0][k]=true;
        pq.offer(new int[]{0,0,dis,k});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            int remk=curr[3];
            if(r==m-1 && c==n-1){return d;}
            for(int[] di:dir){
                int nr=r+di[0];
                int nc=c+di[1];
                if(nr<0 || nr>=m || nc<0 || nc>=n){
                    continue;
                }
                int newk=remk;
                if(grid[nr][nc]==1){
                    newk--;
                }
                if(newk<0 ){
                    continue;
                }
                if(!vis[nr][nc][newk]){
                    vis[nr][nc][newk]=true;
                    pq.offer(new int[]{nr,nc,d+1,newk});
                }
                
            }
        }
        return -1;
    }
}