// 9. Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
        
        int reverseNumber = 0;
        while (x > reverseNumber) {
            int temp = x % 10;
            x /= 10;
            if (x == reverseNumber) {
                return true;
            }
            reverseNumber = (reverseNumber * 10) + temp;
            if (x == reverseNumber) {
                return true;
            }
        }
        return false;
    }
}