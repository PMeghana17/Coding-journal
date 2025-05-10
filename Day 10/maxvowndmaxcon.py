class Solution:
    def maxFreqSum(self, s: str) -> int:
        d={}
        maxcon=0
        maxvow=0
        for i in s:
            if i in d:
                d[i]+=1
            else:
                d[i]=1
        for key,val in d.items():
            if key in ['a','e','i','o','u']:
                maxvow=max(val,maxvow)
            else:
                maxcon=max(val,maxcon)
        return maxvow+maxcon
        
