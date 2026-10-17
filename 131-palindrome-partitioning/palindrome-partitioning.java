class Solution {
    List<List<String>> ans=new ArrayList<>();
    List<String> curr=new ArrayList<>();
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        int n=s.length();
        dp=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2 || dp[i+1][j-1] ){
                        dp[i][j]=true;
                    }
                }
            }
        }
        solve(0,s);
        return ans;
    }
    public void solve(int start,String s){
        if(start==s.length()){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=start;i<s.length();i++){
            if(dp[start][i]){
                curr.add(s.substring(start,i+1));
                solve(i+1,s);
                curr.remove(curr.size()-1);
            }
        }
    }
}