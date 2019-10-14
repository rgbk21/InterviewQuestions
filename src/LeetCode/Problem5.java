package LeetCode;

//Given a string s, find the longest palindromic substring in s.
// You may assume that the maximum length of s is 1000.
public class Problem5 {

    private static String longestPalindrome = "";
    private static String tempPalindrome_1 = "";
    private static String tempPalindrome_2 = "";
    private static String tempPalindrome = "";

    public static String longestPalindrome(String s) {

        int n = s.length();
        int maxLength = 0;

        for(int i = 0; i < n; i++ ){

            int length1 = expandAroundSingleChar(i, n, s);
            int length2 = expandAroundDoubleChar(i, i+1, n, s);

            tempPalindrome = (length1 > length2) ? tempPalindrome_1 : tempPalindrome_2;
            if(tempPalindrome.length() > longestPalindrome.length()){
                longestPalindrome = tempPalindrome;
            }
        }
        return longestPalindrome;
    }

    public static int expandAroundSingleChar(int center, int stringLength, String s){

        int pLength = 0;//Stores the length of the palindrome
        int left = center;
        int right = center;
        while(left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)){
            tempPalindrome_1 = s.substring(left, right+1);
            left--;
            right++;
        }

        return tempPalindrome_1.length() ;
    }

    public static int expandAroundDoubleChar(int left, int right, int stringLength, String s){

        int pLength = 0;//Stores the length of the palindrome
        while(left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)){
            tempPalindrome_2 = s.substring(left, right+1);
            left--;
            right++;
        }
        return tempPalindrome_2.length() ;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaa"));
    }
}
