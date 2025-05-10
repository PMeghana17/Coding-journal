Q-2: [LC-242] Valid Anagram
https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.


Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?



    public boolean isAnagram(String s, String t) 
    {

    }





--------> Understanding:

Jumbled Words/Scramble

a, c, t -----> act, cat : Anagram of each Other



anagram
nagaram

OP: true


rat
car


OP: false



Solution:



Edge Cases:

if (s.size() != t.size())
	return false;


if (s == t)
	return true;



(1) Sorting:

Anagram:
All Characters present with SAME Frequency

Sort Both Strings:
ALL SAME Characters would be Adjacent


Sorting - 2 Reasons:
(1) Apply Any Algo which REQUIRES Sorted values
	(A) Binary Search
	(B) Two Pointers
(2) If we want all same values to be Adjacent



- Sort Both Strings
- Compare Two Strings, If Same - Anagram, Else Not Anagram


s = "anagram"
t = "nagaram"

After Sorting:
s = "aaagmnr", t = "aaagmnr"



CODE:


        bool isAnagram(string s, string t) 
        {
           // Edge Cases:
        // Size different, Not Anagram    
        if (s.size() != t.size())
            return false;
        
        // Same Strings - Anagram    
        if (s == t)
            return true;
         
            
        sort(s.begin(), s.end());  // O(nlogn)  
        sort(t.begin(), t.end());   // O(nlogn)   

        return s==t;
        }


TC: O(2*NlogN)
SC: O(1)

















(2) Hashing - Map

Anagram:
All Characters present with SAME Frequency


Input: s = "rat", t = "car"
OP: false


(1) First Way: 2 Maps

Map-1 for s:

r: 1
a: 1
t: 1



Map-2 for t:

c: 1
a: 1
r: 1


Map1 == Map2
OP: false



(2) Second Way: 1 Map

Input: s = "rat", t = "tar"
OP: true


Map:

For s: Increase Frequency

r: 1
a: 1
t: 1


For t: Decrease Frequency

r: 0
a: 0
t: 0

In Map,
All Values == 0, return true
else, return false




CODE:



 bool isAnagram(string s, string t) 
        {
           // Edge Cases:
        // Size different, Not Anagram    
        if (s.size() != t.size())
            return false;
        
        // Same Strings - Anagram    
        if (s == t)
            return true;
                
        unordered_map<char,int> mp;
            
       int i = 0;
       for (i=0; i<s.size(); i++)  // O(N)
       {
           mp[s[i]]++;
           mp[t[i]]--;
       }
        
            
        // Maximum Number of Unique Characters = 26
            
        // If Anagram - All freq would be 0 at this point
        for (auto it: mp)    // O(26)
        {
            if (it.second) // it.second!=0
                return false;
        }
                
        return true;
        } 


TC: O(N) + O(26)
SC: O(26)



Use Map/HashMap/Dictionary:
Use Set/HashSet:

SC: O(Unique Chars/Elements)


str = "aaaaaaaaab", N = 10
Map:

a - 9
b - 1

map.size() = 2


Lowercase English Characters
Size = a-z: 26











(3) Using Frequency Array

s = "act"
t = "cat"

int[] freq = new int[26];

[0.........0]


freq[0] -> a: 0
freq[25] -> z: 0

freq[s[i]-'a']++;
freq[t[i]-'a']--;



Check:

freq[i]==0, return true, else return false

'c'-'a': 2: freq[2] -> ++




CODE:




class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        // Edge Cases:
        if (s.length()!= t.length())
            return false;
        
        if (s == t)
            return true;
        
        int[] arr = new int[26];
        int i = 0;

        // arr = [0........26 values]
        // arr[0] -> a, arr[1] -> b, arr[2] -> c....

        for (i=0; i<s.length(); i++)
        {
            arr[s.charAt(i)-'a']++; 
            arr[t.charAt(i)-'a']--;
        }

        // If Anagram - All Vaues : 0 After for loop
        for (i=0; i<26; i++)
        {
            if (arr[i] != 0)
                return false;
        }
        
        return true;
    }
}


TC: O(N) + O(26) 
SC: O(26)





ASCII Codes:

A-Z: 
a-z: 65 to 97 





s = "cat"
t = "act"

freq = [0.......0]: 26 Size


arr[s.charAt(i)-'a']++; 


For s:

i = 0, s[i] = 'c'

Expectation: [0,0,1,....0]

arr[s.charAt(0)-'a']++; 
arr['c'-'a']++; 
arr[2]++;

OP: [0,0,1,....0]


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?


Unicode: 256 Size


Array Approach:

int arr[26]: a-z
int arr[256]: Unicode - Ascii characters: 0 to 255


Map Approach:

No Changes Required
