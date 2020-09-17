/**
 * @Author Lichee
 * @Date 2020/9/17 22:09
 * @Version 1.0
 */
public class StringtoIntegeratoi {
    public static void main(String[] args) {
        String str = "   -42";
        System.out.println(myAtoi(str));
        System.out.println('-' >= '0' && '-' <= '9');
    }

    public static int myAtoi(String str) {
        long integer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length()) i++;
            else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            } else {
                integer += str.charAt(i) - '0';
                i++;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    integer *= 10;
                    integer += str.charAt(i) - '0';
                    i++;
                }
                if (integer < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (integer > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return (int) integer;
            }
        }
        return (int) integer;
    }
}
