class Solution {
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        // Map<Integer, List<Integer>> map=new HashMap<>();
        // map.add(1,new ArrayList<>());
        // map.get(1).add(0,1);
        // map.add(2,new ArrayList<>());
        // map.get(2).add(0,-1);
        // map.add(3,new ArrayList<>());
        // map.get(3).add(1,0);
        // map.add(4,new ArrayList<>());
        // map.get(4).add(-1,0);
        int[][] dis=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        // Map<Integer,Integer> didx=new HashMap<>();
        // for(int i=0;i<4;i++){
        //     map.put(i,i+1);
        // }
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        dis[0][0]=0;
        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{0,0});
        while(!dq.isEmpty()){
            int[] q=dq.pollFirst();
            int x=q[0];
            int y=q[1];
            // int cost=q[2];
            if(x==m-1 && y==n-1){
                break;
            }
            for(int d=0;d<4;d++){
                int nx=x+dirs[d][0];
                int ny=y+dirs[d][1];
                if(nx<0 || ny<0 || nx>=m || ny>=n){
                    continue;
                }
                int c=(grid[x][y]==d+1)?0:1;
                if(dis[nx][ny] > dis[x][y]+c){
                    dis[nx][ny] = c+dis[x][y];
                    if(c==0){
                    dq.offerFirst(new int[]{nx,ny});
                    }else{
                        dq.offerLast(new int[]{nx,ny});
                    }
                }
                
                
                
            }
        }
        return dis[m-1][n-1];
    }
}
// 1 1 1 1
// 2 2 2 2 
// 1 1 1 1 
// 2 2 2 2 