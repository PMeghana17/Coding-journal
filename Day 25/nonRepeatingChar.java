class Solution {
    static char nonRepeatingChar(String s) {
        // code here
        char[] charr=new char[26];
        
        for(int i=0;i<s.length();i++)
        {
            charr[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++)
        {
            if(charr[s.charAt(i)-'a']==1)
            return s.charAt(i);
        }
        
        return '$';
    }
}


TC:O(N)
SC:O(1)
