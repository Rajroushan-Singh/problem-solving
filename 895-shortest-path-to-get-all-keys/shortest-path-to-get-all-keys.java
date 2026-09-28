class State{
    int r;
    int c;
    String key;
    State(int r,int c,String key){
        this.r=r;
        this.c=c;
        this.key=key;
    }
}
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m=grid.length;
        int n=grid[0].length();
        int sr=0;int sc=0;
        int totalkeys=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='@'){
                    sr=i;sc=j;
                }
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f' ){
                    totalkeys++;
                }
            }
        }
        int[] keyidx=new int[6];  
        Queue<State> q=new LinkedList<>();
        Set<String>[][] vis=new HashSet[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=new HashSet<>();
            }
        }
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        q.offer(new State(sr,sc,""));
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-- >0){
                State curr=q.poll();
                int r=curr.r;
                int c=curr.c;
                String keys=curr.key;
                if(keys.length()==totalkeys){
                    return step;
                }
                for(int[] d:dir){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr<0 || nr>=m || nc<0 || nc>=n){continue;}
                    char ch=grid[nr].charAt(nc);
                    if(ch=='#'){
                        continue;
                    }
                    if(ch>='A' && ch<='F'){
                        char reqch=Character.toLowerCase(ch);
                        if(keys.indexOf(reqch)==-1){continue;}

                    }
                    String newkey=keys;

                    if(ch>='a' && ch<='f'){
                        if(keys.indexOf(ch)==-1){
                            newkey=keys+ch;
                        }


                    }

                    if(vis[nr][nc].contains(newkey)){
                        continue;
                    }
                    vis[nr][nc].add(newkey);
                    q.offer(new State(nr,nc,newkey));
                }
            }
            step++;

            
        }
        return -1;
    }
}