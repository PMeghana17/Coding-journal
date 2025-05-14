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
