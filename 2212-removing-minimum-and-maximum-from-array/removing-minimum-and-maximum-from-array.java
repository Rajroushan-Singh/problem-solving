class Solution {
    public int minimumDeletions(int[] nums) {
        int mini=0;
        int maxi=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[mini]){
                mini=i;
            }
            if(nums[i]>nums[maxi]){
                maxi=i;
            }
        }
        if(mini>maxi){
            int t=mini;
            mini=maxi;
            maxi=t;
            
        }
        int f=Math.max(mini,maxi)+1;
        int b=n-Math.min(mini,maxi);
        int fb=mini+1 + n-maxi;
        return Math.min(f,Math.min(b,fb));
    }
}