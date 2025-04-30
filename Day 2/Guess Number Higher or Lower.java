/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i=1;
        int j=n;

        while(i<=j)
        {
            int mid=i+(j-i)/2;//to get rid of over flow i used this trick
            //also thought of using long type but the guess method is accepting only int 
            //int guess(int num)
            if(guess(mid)==-1)
            {
                j=mid-1;
            }
            else if(guess(mid)==1)
            {
                i=mid+1;
            }
            else //let's try if we replace [else if(guess(mid)==0)]
            //without using separate the else if condition for the guess(mid)==0
            // simply to else
            {
                return mid;
            }

        }

        return 0;// didn't understand what to return if the number is nogt within teh range
        //so we can return any interger value
    }
}
