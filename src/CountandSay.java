/**
 * @Author Lichee
 * @Date 2020/9/17 20:38
 * @Version 1.0
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/886/
 * Count and Say
 */
public class CountandSay {
    public static void main(String[] args){
        for(int i=1;i<11;i++){
            System.out.println(countAndSay(i));
        }
/*
        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        6.     312211
        7.     13112221
        8.     1113213211
        9.     31131211131221
        10.    13211311123113112211*/
    }

    // Your runtime beats 33.80 % of java submissions
    // Your memory usage beats 12.97 % of java submissions.
    public static String countAndSay(int n) {
        if(n==1) return "1";
        else{
            String input =  countAndSay(n-1);
            String output ="";
            for(int i=0;i<input.length();i++){
                int count=1;
                char num = input.charAt(i);
                while ((i+1)<input.length()&&input.charAt(i+1)==num){
                    count++;
                    i++;
                }
                output+=count;
                output+=num;
            }
            return output;
        }
    }
}
