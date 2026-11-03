class Solution {
    public int minBitFlips(int start, int goal) {
        int c=0;
        int l=Math.max(Integer.toBinaryString(start).length() ,
                        Integer.toBinaryString(goal).length());
        for(int i=0;i<=l;i++){
            if(((start>>i)&1) != ((goal>>i)&1)  ){
                c++;
            }
        }
        return c;
    }
}