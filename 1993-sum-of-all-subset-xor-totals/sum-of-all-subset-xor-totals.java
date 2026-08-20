class Solution {
    // int ans=0;

    public int subsetXORSum(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor|=nums[i];
        }
        int p=(int)Math.pow(2,nums.length-1);
        return xor* p;
    }
}