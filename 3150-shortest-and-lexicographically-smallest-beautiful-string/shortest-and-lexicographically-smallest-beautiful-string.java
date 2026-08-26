class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int ones = 0;
        int n = s.length();
        int start = 0;
        int minlen = Integer.MAX_VALUE;
        String ans = "";

        for (int end = 0; end < n; end++) {
            ones += s.charAt(end) - '0';

            while (ones > k) {
                ones -= s.charAt(start) - '0';
                start++;
            }

            if (ones == k) {

                // Remove unnecessary leading zeros
                while (s.charAt(start) == '0') {
                    start++;
                }

                String temp = s.substring(start, end + 1);

                if (temp.length() < minlen ||
                    (temp.length() == minlen && temp.compareTo(ans) < 0)) {
                    
                    minlen = temp.length();
                    ans = temp;
                }
            }
        }

        return ans;
    }
}
