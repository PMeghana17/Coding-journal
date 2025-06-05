// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        int len1=s1.length();
        int len2=s2.length();
        int maxlen=Math.max(len1,len2);
        
        s1=String.format("%"+maxlen+"s",s1).replace(' ','0');
        s2=String.format("%"+maxlen+"s",s2).replace(' ','0');
        
        //System.out.println(s1);
        //System.out.println(s2);
        int i=maxlen-1;
        int c=0;
        StringBuilder res=new StringBuilder();
        //char[] s11=s1.toCharArray();
        //char[] s22=s2.toCharArray();
        
       // System.out.println(java.util.Arrays.toString(s11));
       // System.out.println(java.util.Arrays.toString(s22));
        
        while(i>=0)
        {
            int c1=s1.charAt(i)-'0';
            int c2=s2.charAt(i)-'0';
            int sum=c1+c2+c;
            
            res.append(sum%2);
           // System.out.println(res);
            c=sum/2;
            i--;
            
        }
return (res.append(c)).reverse().toString().replaceFirst("^0+(?!$)", "");
    }
}

✅ Final Time Complexity:
O(n)
  ✅ Space Complexity:
O(n)
