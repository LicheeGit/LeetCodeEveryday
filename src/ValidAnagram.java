import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lichee
 * @Date 2020/9/17 17:15
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
 * Valid Anagram
 */
public class ValidAnagram {
    public static void main(String[] args){
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        List<Character> words = new ArrayList<>(s.length());
        for(int i=0;i<s.length();i++){
            words.add(s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(words.contains(t.charAt(i))) {
                words.remove(words.indexOf(t.charAt(i)));
            }
            else return false;
        }
        return true;
    }
}
