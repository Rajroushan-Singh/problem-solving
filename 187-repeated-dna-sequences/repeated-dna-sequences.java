class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String , Integer> map=new HashMap<>();
        List<String> ans=new ArrayList<>();
        for(int i=0;i+10<=s.length();i++){
            String str=s.substring(i,i+10);
            map.put(str,map.getOrDefault(str,0)+1);
            int c=map.getOrDefault(str,0);
            if(c==2){
                ans.add(str);
            }

        }
        return ans;
    }
}