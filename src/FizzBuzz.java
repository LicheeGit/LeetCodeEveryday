import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lichee
 * @Date 2020/9/20 23:01
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/743/
 * Fizz Buzz
 */
public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        List<String> result = fizzBuzz(n);
        for (String i : result) {
            System.out.println(i);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0) {
                result.add("FizzBuzz");
                continue;
            }
            if(i%3==0){
                result.add("Fizz");
                continue;
            }
            if(i%5==0){
                result.add("Buzz");
                continue;
            }
            result.add(String.valueOf(i));
        }
        return result;
    }
}
