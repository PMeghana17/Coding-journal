import java.util.Arrays;
public class Solution {
    public static String read(int n, int []book, int target){
        // Write your code here.
        Arrays.sort(book);
        int i=0;
        int j=n-1;

        while(i<=j)
        {
            if(book[i]+book[j]>target)
            {
                j--;
            }
            else if(book[i]+book[j]<target)
            {
                i++;
            }
            else{
                return "YES";
            }
        }

        return "NO";
    }
}
