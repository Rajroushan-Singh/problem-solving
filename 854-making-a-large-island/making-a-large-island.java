class Solution {
    // int m;
    int n;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    HashMap<Integer,Integer> size=new HashMap<>();

    public void dfs(int i,int j,int[][] grid,int c){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!= 1){
            return ;
        }
        grid[i][j]=c;
        size.put(c,size.getOrDefault(c,0)+1);
        for(int k=0;k<4;k++){
            dfs(i+dx[k],j+dy[k] , grid,c);
        }
    }
    public int largestIsland(int[][] grid) {
        // m=
        n=grid.length;
        int c=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,c);
                    c++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int newi=i+dx[k];
                        int newj=j+dy[k];
                        if(newi<0 || newj<0 || newi>=n || newj>=n){
                            continue;
                        }
                        if(grid[newi][newj]>1){
                            set.add(grid[newi][newj]);
                        }

                    }
                    int x=1;
                    for(int a:set){
                        x+=size.get(a);
                    }
                    ans=Math.max(ans,x);
                }
            }
        }
        if(ans==0){
            return n*n;
        }
        return ans;
    }

}