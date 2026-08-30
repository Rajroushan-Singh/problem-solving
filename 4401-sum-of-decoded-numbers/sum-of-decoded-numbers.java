class Solution {
    public int sumDecoded(long[] nums) {
        long ans=0;
        long mod=1000000007L;
        int n=nums.length;
        long d=0;
        long x=0;
        long y=0;
        for(long num:nums){
            int w=(int)(num%10);
            d=num/10;
            String s=String.valueOf(d);
            x=Long.parseLong(s.substring(0,w));
            y=Long.parseLong(s.substring(w));
            long q=modPow(x,y,mod);
            ans=(ans+q)%mod;

        }
        return (int)(ans%mod);
    }
     private long modPow(long x, long y, long MOD) {
        long result = 1;

        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % MOD;
            }

            x = (x * x) % MOD;
            y /= 2;
        }

        return result;
    }
}