class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;int n=nums.length;
        boolean haszero=false;
        for(int num :nums){
            xor^=num;
            if(num!=0){
                haszero=true;
            }
        }
        if(xor!=0){
            return n;
        }
        if(haszero)return n-1;
        return 0;
    }
}