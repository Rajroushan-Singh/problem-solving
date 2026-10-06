class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0;
        int totalcost=0;
        int tank=0;
        int idx=0;
        for(int i=0;i<gas.length;i++){
            totalcost+=cost[i];
            totalgas+=gas[i];
            tank+=(gas[i]-cost[i]);
            if(tank<0){
                idx=i+1;
                tank=0;
            }
        }
        if(totalcost>totalgas){return -1;}
    return idx;
        
    }
}