class Solution {
    public int minimumEffortPath(int[][] heights) {

        int row=heights.length;
        int col=heights[0].length;
        // List<List<int[]>> g=new ArrayList<>();
        // for(int i=0;i<)
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][] dis=new int[row][col];
        dis[0][0]=0;
        for(int i=0;i<row;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        // int curreffort=0;
        // int maxeffort=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int x=curr[0];
            int y=curr[1];
            int effort=curr[2];                
            if (effort > dis[x][y]) continue;
            if (x == row - 1 && y == col - 1)
                return effort;
            for(int[] dir:dirs){
                int newx=x+dir[0];int newy=y+dir[1];

                if(newx>=0 && newx<row && newy>=0 && newy<col ){
                    int edgeffort=Math.abs(heights[x][y] -heights[newx][newy]);
                    int neweffort=Math.max(effort,edgeffort);
                    if(neweffort< dis[newx][newy]){
                        dis[newx][newy]=neweffort;
                        pq.offer(new int[]{newx,newy,neweffort});
                    }                        
                    // curreffort=Math.abs(heights[x][y] -heights[newx][newy]);
                    // maxeffort=Math.max(maxeffort,curreffort);

                }
            }
        }
        return dis[row-1][col-1];
    }
}