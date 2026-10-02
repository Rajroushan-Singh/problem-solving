class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> full = new ArrayList<>();
        
        StringBuilder half = new StringBuilder();

        backtrack(0, 0, n, half, full);
        
        return full;
    }


        public void backtrack(int open, int close, int n, StringBuilder half, List<String> full) {
        if (open == n && close == n) {
            full.add(half.toString());  
            return;
        }

        if (open < n) {
            half.append('(');  
            backtrack(open + 1, close, n, half, full);  
            half.deleteCharAt(half.length() - 1);  
        }

        if (close < open) {
            half.append(')');  
            backtrack(open, close + 1, n, half, full); 
            half.deleteCharAt(half.length() - 1); 
        }


        
        
    }
}