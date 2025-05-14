class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        // Append only alphanumeric characters in lowercase
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        // Use two-pointer technique to compare characters from both ends
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


Mistakes
  -At first didn't thought of two pinter technique i directly used the reverse() method and checked whether the 
  orginal and the reversed one is same.
