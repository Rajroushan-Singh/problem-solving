    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n=coins.length;
            int[][] dp=new int[amount+1][n+1];
            for(int i=1;i<amount+1;i++){
                dp[i][0]=Integer.MAX_VALUE-1;
            }
            for(int j=0;j<n+1;j++){
                dp[0][j]=0;
            }
            for(int i=1;i<amount+1;i++){
                for(int j=1;j<n+1;j++){
                    if(coins[j-1]<=i){
                        dp[i][j]=Math.min(dp[i][j-1],1+dp[i-coins[j-1]][j]);
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
            return dp[amount][n]==Integer.MAX_VALUE-1? -1:dp[amount][n];
        }
    }