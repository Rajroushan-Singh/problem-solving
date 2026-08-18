class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<=n;i++){
            for(int num=1;num*num<=i;num++){
                if(i-(num*num)>=0){
                    dp[i]=Math.min(dp[i],1+dp[i-num*num]);
                }
            }
        }
        return dp[n];
    }
}