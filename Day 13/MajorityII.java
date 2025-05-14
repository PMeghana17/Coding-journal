class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> ans=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=nums.length/3;
        
        //Used treeMap here bcoz the list we are returning should be in sorted
        //order
        
        //so map collected teh frequency of each candidate
        for(Integer i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        //if the value is > length/3 then add that value to list
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>n)
            {
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
}


------------->Points
    Maybe i can initially should have sorted the nums array and then simply created hashmap ....but sorting the array 
    Will take O(NlogN) TC


    
------------------------
✅ Time Complexity:
1. Inserting into TreeMap:
Each insertion: O(log k) where k is the number of unique elements.

For nums.length = m, worst case all elements are unique → O(m log m).

2. Iterating over map entries:
O(k), where k is the number of unique elements (at most m).

➡️ Total Time Complexity: O(m log m)

------------------------------------

✅ Space Complexity:
TreeMap: stores up to m entries → O(m) in worst case (all unique).

ans list: stores up to 2 elements (max possible with >n/3 condition).

➡️ Total Space Complexity: O(m)




--------the optimized Boyer-Moore Voting Algorithm solution 
    O(n) time and O(1) space------in readme
