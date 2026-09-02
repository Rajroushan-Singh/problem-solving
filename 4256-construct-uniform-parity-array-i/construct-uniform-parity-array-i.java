class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int n=nums1.length;
        // int[] p=new int[n];
        boolean haseven=false;
        boolean hasodd=false;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                haseven=true;
            }else{
                hasodd=true;
            }
        }
        return true;
    }
}