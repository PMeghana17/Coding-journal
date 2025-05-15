class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        int profit=0;
        int i=0;
        
        // My Idea is to catch the element where the non decreasing order 
        //breaks....then after that take the profit from starting i;
        while(i<prices.length)
        {
            int j=i;
            while(j<prices.length)
            {
                if(j+1<prices.length && prices[j]<prices[j+1])
                {
                    j++;
                }
                else
                {
                    break;
                }
            }
            
            profit+=prices[j]-prices[i];
            i=j+1;
        }
        
        return profit;
        
    }
}


⏱️ Time Complexity: O(N)
Even though I use nested while loops, here’s why it's still linear:

i is updated as i = j + 1, and j only moves forward.

Every element is visited at most once by both i and j.

So the total number of operations across both loops is at most 2N, which simplifies to O(N).

✅ Efficient and meets the constraint.

  📦 Space Complexity: O(1)
No extra data structures used.

Just a few integer variables (profit, i, j).

✅ Constant space.


