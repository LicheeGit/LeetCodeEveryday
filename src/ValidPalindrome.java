/**
 * @Author Lichee
 * @Date 2020/9/17 19:49
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 * Valid Palindrome :Consider alphanumeric
 */
public class ValidPalindrome {
    public static void main(String[] args){
        String s ="0p";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if(s==""||s.length()==1) return true;
        s=s.toLowerCase();
        char[] sentence = new char[s.length()];
        int letterCount=0;
        for(int i=0;i<s.length();i++){
            if(('a'<=s.charAt(i)&&s.charAt(i)<='z')||('A'<=s.charAt(i)&&s.charAt(i)<='Z')||('0'<=s.charAt(i)&&s.charAt(i)<='9')){
                sentence[letterCount++]=s.charAt(i);
            }
        }
        int start=0;
        int end=letterCount-1;
        while (start<end){
            if(sentence[start++]!=sentence[end--]) return false;
        }
        return true;
    }
}
