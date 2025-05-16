// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int minSofar=prices[0];
        int maxProfit=0;
        
        for(int i=1;i<prices.length;i++)
        {
            minSofar=Math.min(minSofar,prices[i]);
            
            if(prices[i]>minSofar)
            maxProfit=Math.max(maxProfit,prices[i]-minSofar);
        }
        
        return maxProfit;
        
    }
}
