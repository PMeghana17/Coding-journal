class Solution:
    def sumOfLargestPrimes(self, s: str) -> int:
        seet=set()
        for i in range(len(s)):
            for j in range(i,len(s)):
                num=int(s[i:j+1])
                if self.isPrime(num):
                    seet.add(num)
        first=max(seet,default=0)
        seet.discard(first)
        sec=max(seet,default=0)
        seet.discard(sec)
        third=max(seet,default=0)
        return first+sec+third
        
            
                
        
    
    def isPrime(self,num:int)-> bool:
        if num<2:
            return False
        for i in range(2,int(sqrt(num))+1):
            if num%i==0:
                return False
        return True
        
