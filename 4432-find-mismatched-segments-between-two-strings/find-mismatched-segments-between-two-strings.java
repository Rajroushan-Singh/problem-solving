class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int n=s1.length();
        int i=0;
        List<List<String> > ans=new ArrayList<>();

        while(i<n){
            if(s1.charAt(i)==s2.charAt(i)){
                i++;
                continue;
            }else{
                int prev=i;
                while(i<n && s1.charAt(i)!=s2.charAt(i)){
                    i++;
                    
                }
                String str1=s1.substring(prev,i);
                String str2=s2.substring(prev,i);
                List<String> ls=new ArrayList<>();
                ls.add(str1);ls.add(str2);
                ans.add(ls);


            }
            i++;
        }
        return ans;
    }
}