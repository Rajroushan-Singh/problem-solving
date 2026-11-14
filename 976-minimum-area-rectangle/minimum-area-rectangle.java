class Solution {
    public int minAreaRect(int[][] points) {
        int n=points.length;
        if(n<4)return 0;
        Set<String> set=new HashSet<>();
        for(int[] p:points){
            set.add(p[0]+","+p[1]);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                if(x1==x2 || y1==y2)continue;
                if(set.contains(x1+","+y2 )&& set.contains(x2+","+y1)){
                    min=Math.min(Math.abs(x2-x1) * (Math.abs(y1-y2)) , min);
                }
                

            }
            
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}