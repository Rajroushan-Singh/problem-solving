class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        int n=s.length();
        for(int i=1;i<=n;i++){
            for(int k=0;k<=n-i;k++){
                if(check(s.substring(k,k+i))){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean check(String str){
        int i=0,j=str.length()-1;
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}