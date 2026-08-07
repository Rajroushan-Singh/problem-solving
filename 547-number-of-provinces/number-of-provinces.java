class Solution {
    public int find(int x,int[] parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent) ;
        }
        return parent[x];
    }
    public void union(int a,int b, int[] parent){
        int pa=find(a,parent);
        int pb=find(b,parent);
        if(pa!=pb){
            parent[pb]=pa;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    union(i,j,parent);
                }
            }
        }
        // int[] max=new int[n];
        // for(int i=0;i<n;i++){
        //     max[parent[i]]++;
        // }

        int c=0;
        for(int i=0;i<n;i++){
            if(find(i,parent) == i){
                c++;
            }
        }
        return c;

    }
}