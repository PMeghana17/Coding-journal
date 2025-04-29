class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        //sorting really helped to get the answer simple
        //maybe it's not the optimised 
        String res="";
        int n=strs.length;
        char[] ch1=strs[0].toCharArray();
        char[] ch2=strs[n-1].toCharArray();
        for(int i=0;i<ch1.length && i<ch2.length ;i++)// && is imp to check for index out of bound error
        {
            if(ch1[i]!=ch2[i])
            {
                break;
            }
            res+=ch1[i];
            //it will store the result string of till now matched
        }

        return res;
    }
}

