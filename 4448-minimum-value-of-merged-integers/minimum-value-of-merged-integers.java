class Solution {
    public int minMergedInteger(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i+=2){
            int a=nums[i];
            int b=nums[i+1];
            // int num=b;
            int l=String.valueOf(b).length();
            int m=0;
            // while(num!=0){
            //     l++;
            //     num/=10;
            // }
            m=a*(int)Math.pow(10,l) +b;
            min=Math.min(m,min);
        }
        return min;
    }
}