/**
 * @Author Lichee
 * @Date 2020/9/17 9:13
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 * Reverse String
 */
public class ReverseString {
    public static void main(String args[]){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int front = 0;
        int back = s.length-1;
        while (front<back){
            char temp = s[front];
            s[front] =s[back];
            s[back] =temp;
            front++;
            back--;
        }
    }
}
