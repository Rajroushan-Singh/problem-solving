class Solution {
    public int findKthNumber(int n, int k) {
        long curr=1;
        k--;
        // int i=1;
        while(k>0){
           long step=count(curr , curr+1 , n);
            if(step<=k){
                k-=step;
                curr++;
            }else{
                curr*=10;
                k--;
            }

        }
        return (int)curr;
    }
    public long count(long curr,long next,int n){
        long steps=0;
        while(curr<=n){
            steps+=Math.min((long)n+1,next)-curr;
            curr*=10;
            next*=10;
        }
        return steps;
    }
}