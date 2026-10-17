class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=Arrays.stream(stones).reduce(0,(a,b)->a+b);
        int n=stones.length;
        boolean[][] dp=new boolean[n+1][sum/2 +1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n ;i++){
            for(int j=1;j<=sum/2 ;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=stones[i-1]){
                    dp[i][j]=dp[i][j]||dp[i-1][j-stones[i-1]];
                }
                    
                
            }
        }
        
        for(int j=sum/2;j>=0;j--){
            if(dp[n][j]){
                return sum-2*j;
            }
        }
        return 0;
    }
}