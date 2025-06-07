class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        if(s1.length()!=s2.length()) return false;
        int n=s1.length();
        
        char[] charr=new char[26];
        
        for(int i=0;i<n;i++)
        {
            charr[s1.charAt(i)-'a']++;
        }
        
        for(int i=0;i<n;i++)
        {
            charr[s2.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++)
        {
            if(charr[i]!=0) return false;
        }
        
        return true;
    }
}

TC:O(N)
SC:O(1) ----array of size O(26) --->O(1)
