class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=succProb[i];
            g.get(u).add(new double[]{v,p});
            g.get(v).add(new double[]{u,p});
        }
        double[] prob=new double[n];
        Arrays.fill(prob,0);
        prob[start_node]=1;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        pq.offer(new double[]{start_node,1});
        while(!pq.isEmpty()){
            double[] curr=pq.poll();
            int node=(int)curr[0];
            double wt=curr[1];
            if(node==end_node){
                break;
            }
            if(wt<prob[node]){continue;}
            for(double[] nei:g.get(node)){
                int next=(int)nei[0];
                double p=nei[1];
                if(p*wt>prob[next]){
                    prob[next]=p*wt;
                    pq.offer(new double[]{next,prob[next]});
                }
            }
        }
        // double ans=0;
        // for(double i:prob){
        //     ans=Math.max(i,ans);
        // }
        return prob[end_node];
    }
}