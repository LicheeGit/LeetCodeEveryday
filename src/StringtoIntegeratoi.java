/**
 * @Author Lichee
 * @Date 2020/9/17 22:09
 * @Version 1.0
 */
public class StringtoIntegeratoi {
    public static void main(String[] args) {
        /*String[] strs = {"    -42 ", "9223372036854775808", "-91283472332", "4193 with words", "42", " ", "+",
                "-0001", "  * ", " --+5 08", "+-9823","2147483648", "-2147483648", "-2147483647"};
        for (String str : strs) {
            System.out.println(myAtoi(str));
        }*/
        String str = "-2147483647";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        int i = 0;
        long integer = 0;
        boolean negetive = false;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i < str.length() && str.charAt(i) == '-') {
            negetive = true;
            i++;
        } else if (i < str.length() && str.charAt(i) == '+') {
            i++;
        }
        if (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            while (i < str.length() && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                integer *= 10;
                integer += str.charAt(i) - '0';
                i++;
                if(negetive){
                    if((0-integer)<=Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
                if(integer>=Integer.MAX_VALUE){
                    if(!negetive) return Integer.MAX_VALUE;
                }
            }
            if(negetive){
                return 0-(int) integer;
            }
            return (int) integer;
        }
        return 0;
    }
}
