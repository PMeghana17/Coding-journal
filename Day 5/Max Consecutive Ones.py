#LEETCODE 485
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count=0
        maxx=0
        for i in range(len(nums)):
            if nums[i]==1:
                count+=1
            else:
                maxx=max(count,maxx)
                count=0
        return max(maxx,count)
        
                
