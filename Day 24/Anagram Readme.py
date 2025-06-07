Check if two Strings are Anagrams of each other
Given two strings s1 and s2 consisting of lowercase characters, the task is to check whether the two given strings are anagrams of each other or not.
An anagram of a string is another string that contains the same characters, only the order of characters can be different.

Examples:

Input: s1 = “geeks”  s2 = “kseeg”
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.

Input: s1 = “allergy”  s2 = “allergic”
Output: false
Explanation: Characters in both the strings are not same. s1 has extra character 'y' and s2 has extra characters 'i' and 'c', so they are not anagrams.

Input: s1 = "g", s2 = "g"
Output: true
Explanation: Characters in both the strings are same, so they are anagrams.

Table of Content

[Naive Approach] Using Sorting
[Expected Approach 1] Using Hash Map or Dictionary
[Expected Approach 2] Using Frequency Array
[Naive Approach] Using Sorting
The idea is that if the strings are anagrams, then their characters will be the same, just rearranged.
Therefore, if we sort the characters in both strings, the sorted strings will be identical if the original strings were anagrams.
We can simply sort the two given strings and compare them – if they are equal, then the original strings are anagrams of each other.




// Java Code to check if two Strings are anagrams of 
// each other using sorting
​
import java.util.Arrays;
​
class GfG {
​
    // Function to check if two strings are anagrams
    static boolean areAnagrams(String s1, String s2) {
        
        // Sort both strings
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
​
        // Compare sorted strings
        return Arrays.equals(s1Array, s2Array);
    }
​
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2));
    }
}

Output
true
Time Complexity: O(m*log(m) + n*log(n)), where m and n are length of string s1 and s2 respectively.
Auxiliary Space: O(1) where the strings are mutable but O(n) in languages like Java, Python, C#, etc. where strings are immutable.

[Expected Approach 1] Using Hash Map or Dictionary
The idea is to use a hash map or dictionary count the frequency of each character in both the input strings. 
If the frequency of every character matches in both strings, then the strings are anagrams.

First, count the occurrences of each character in first string.
Then, decrement the count for each character in the second string.
If the strings are anagrams, all positions in the frequency array should be zero as any non-zero position means that the frequency of that character is not same in both strings.



// Java Code to check if two Strings are anagram of 
// each other using Hash map
​
import java.util.HashMap;
​
class GfG {
    
    static boolean areAnagrams(String s1, String s2) {
        
        // Create a hashmap to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Count frequency of each character in string s1
        for (char ch : s1.toCharArray()) 
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
  
        // Count frequency of each character in string s2
        for (char ch : s2.toCharArray()) 
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
  
        // Check if all frequencies are zero
        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
        
        // If all conditions satisfied, they are anagrams
        return true;
    }
​
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2) ? "true" : "false");
    }
}

Output
true
Time Complexity: O(m + n), where m and n are length of string s1 and s2 respectively.
Auxiliary Space: O(26) = O(1). The input strings can only have lowercase letters, so there can be at most 26 distinct characters in the hash map.

[Expected Approach 2] Using Frequency Array
Instead of using a hash map to store the frequency of each character, we can create a frequency array of size 26 by using characters as index in this array.
The frequency of ‘a’ is going to be stored at index 0, ‘b’ at 1, and so on. To find the index of a character, we subtract character a’s ASCII value from the ASCII value of the character.

Count character frequency in the first string, then for each character in the second string, decrement its count from the frequency array. 
If the strings are anagrams, all positions in the frequency array will be zero. Any non-zero position means the frequency of that character is not equal in both the strings.

Working:

anagrams-2.webpanagrams-2.webp





// Java Code to check if two Strings are anagram of 
// each other using Frequency Array
​
class GfG {
​
    // As the input strings can only have lowercase 
    // characters, the maximum characters will be 26
    static final int MAX_CHAR = 26;
​
    static boolean areAnagrams(String s1, String s2) {
        int[] freq = new int[MAX_CHAR];
​
        // Count frequency of each character in string s1
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;
​
        // Count frequency of each character in string s2
        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;
​
        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0)
                return false;
        }
​
        return true;
    }
​
    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "kseeg";
        System.out.println(areAnagrams(s1, s2));
    }
}

Output
true
Time Complexity: O(m + n), where m and n are length of string s1 and s2 respectively.
Auxiliary Space: O(MAX_CHAR) = O(26) = O(1), the input strings can only have lowercase letters, so we only need frequency array of size 26.
