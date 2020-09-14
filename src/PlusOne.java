/**
 * @Author Lichee
 * @Date 2020/9/14 15:50
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 * Plus One
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        digits = plusOne(digits);
        for (int digit : digits) {
            System.out.println(digit);
        }
    }

    public static int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int[] result;
        while (index>=0) {
            if (digits[index] == 9) {
                digits[index--] = 0;
            } else {
                digits[index] = digits[index] + 1;
                break;
            }
        }
        if(index<0){
            int[] nResult=new int[digits.length+1];
            int i=0;
            nResult[i++]=1;
            for(int digit:digits){
                nResult[i++]=digit;
            }
            return nResult;
        }
        result=digits;
        return result;
    }
}
